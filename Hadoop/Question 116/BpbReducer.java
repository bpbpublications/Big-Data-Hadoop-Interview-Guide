public class BpbReducer  extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable> {    
    public void reduce(Text key, Iterator<IntWritable> values,OutputCollector<Text,IntWritable> output,    
     Reporter reporter) throws IOException {    
    int sum=0;    
    for (IntWritable value: values) {    
    sum+=value.get();    
    }    
    output.collect(key,new IntWritable(sum));    
    }    
    }  
