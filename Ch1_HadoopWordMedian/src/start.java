import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.BasicConfigurator;

public class start extends Configured implements Tool {
    public enum MediumCounter {
          SUM
         }
    
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        int res = ToolRunner.run(new Configuration(), new start(), args);
        System.exit(res);
    }

    public int run(String[] args) throws Exception {
        // When implementing tool

        Configuration conf = this.getConf();
        
        File outDir = new File(args[1]+"/second");
        if(outDir.exists())
        {
            FileUtils.deleteDirectory(outDir);
        }
        File outDir2 = new File(args[1]+"/first");
        if(outDir2.exists())
        {
            FileUtils.deleteDirectory(outDir2);
        }

        // Create job

        Job job = Job.getInstance(conf, "Tool Job");
        job.setJarByClass(CountKeyword.class);
        // Setup MapReduce job

        // Do not specify the number of Reducer:Using -D mapred.reduce.tasks=1

        job.setMapperClass(CountKeyword.ConutMapper.class);
        job.setCombinerClass(CountKeyword.CountReducer.class);
        job.setReducerClass(CountKeyword.CountReducer.class);
        // Specify key / value

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // Input

        FileInputFormat.addInputPath(job, new Path(args[0]));
        // Output

        FileOutputFormat.setOutputPath(job, new Path(args[1]+"/first"));
        

        // Create job

        Job job2 = Job.getInstance(conf, "Tool Job2");
        job2.setJarByClass(Medium.class);
        // Setup MapReduce job

        // Do not specify the number of Reducer:Using -D mapred.reduce.tasks=1

        job2.setMapperClass(Medium.ExchangeKeyValueMapper.class);
        //job2.setCombinerClass(Medium.WordCountingReducer.class);

        job2.setReducerClass(Medium.WordCountingReducer.class);
        job2.setMapOutputKeyClass(IntWritable.class);
        job2.setMapOutputValueClass(Text.class);
        // Specify key / value

        job2.setOutputKeyClass(IntWritable.class);
        job2.setOutputValueClass(Text.class);
        // Input

        FileInputFormat.addInputPath(job2, new Path(args[1]+"/first"));
        // Output

        FileOutputFormat.setOutputPath(job2, new Path(args[1]+"/second"));
        // Execute job and return status

        
        
        return job.waitForCompletion(true)&&job2.waitForCompletion(true)? 0 : 1;
        
        
    }

}