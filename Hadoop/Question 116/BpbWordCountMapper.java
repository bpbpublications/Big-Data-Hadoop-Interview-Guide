public class BpbWordCountMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{    
    private final static IntWritable one = new IntWritable(1);    
    private Text wordText = new Text();    
    public void map(LongWritable key, Text value,OutputCollector<Text,IntWritable> output,     
           Reporter reporter) throws IOException{    
        String readLine = value.toString();    
        StringTokenizer  tokenizer = new StringTokenizer(readLine);    
        while (tokenizer.hasMoreTokens()){    
            wordText.set(tokenizer.nextToken());    
            output.collect(wordText, one);    
        }    
    }        
}  
