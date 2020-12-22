public class BpbWordCountRunner {    
        public static void main(String[] args) throws IOException{    
            JobConf jobConf = new JobConf(BpbWordCountRunner.class);    
            jobConf.setJobName("BpbWordCount");    
            jobConf.setOutputKeyClass(Text.class);    
            jobConf.setOutputValueClass(IntWritable.class);            
            jobConf.setMapperClass(BpbWordCountMapper.class);    
            jobConf.setCombinerClass(BpbReducer.class);    
            jobConf.setReducerClass(BpbReducer.class);         
            jobConf.setInputFormat(TextInputFormat.class);    
            jobConf.setOutputFormat(TextOutputFormat.class);           
            FileInputFormat.setInputPaths(jobConf,new Path(args[0]));    
            FileOutputFormat.setOutputPath(jobConf,new Path(args[1]));     
            JobClient.runJob(jobConf);    
        }    
    }  
