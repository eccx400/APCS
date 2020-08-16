import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class CountKeyword {

    public static boolean isEnglish(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static class ConutMapper extends
            Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            
            String line = value.toString();
            char[] charArray = line.toCharArray();
            int lastIndex = -1;
            for (int i = 0; i < charArray.length; i++) {
                char current = charArray[i];
                if (!isEnglish(current)) {
                    if ((i - lastIndex) > 1) {
                        String candidate = line.substring(lastIndex + 1, i);
                        word.set(candidate);
                        context.write(word, one);
                    }
                    lastIndex = i;
                }
            }
            
        }
    }

    public static class CountReducer extends
            Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values,
                Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }
}