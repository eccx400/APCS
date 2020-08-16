
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mediumWord.start.MediumCounter;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;



public class Medium {
    
    public static class ExchangeKeyValueMapper extends
            Mapper<Object, Text, IntWritable, Text> {

        private final static IntWritable count = new IntWritable();
        private Text word = new Text();
        private static Pattern linePtn = Pattern.compile("(?<word>[A-Za-z]*)\\s(?<count>[0-9]+)"); 
        @Override
        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            String line = value.toString();
            Matcher match = linePtn.matcher(line);
            if(match.matches()){
                count.set(Integer.parseInt(match.group("count")));
                word.set(match.group("word"));
                context.write(count,word);
            }
            
        }

    }

    public static class WordCountingReducer extends
            Reducer<IntWritable, Text, IntWritable, Text> {
        @Override
        public void reduce(IntWritable key, Iterable<Text> values,
                Context context) throws IOException, InterruptedException {
            
            StringBuilder sb = new StringBuilder();
            int size=0;
            sb.append("{wordlist:[");
            for (Text val : values) {
                sb.append("\""+val.toString()+"\",");
                context.getCounter(MediumCounter.SUM).increment(1);
                size++;
            }
            sb.replace(sb.toString().length()-1, sb.toString().length(),"");
            sb.append("],wordlength:"+size+",");
            
            sb.append("sum:"+context.getCounter(MediumCounter.SUM).getValue()+"}");
            context.write(key, new Text(sb.toString()));
        }
    }
}