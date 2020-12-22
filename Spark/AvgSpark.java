public class AvgSpark{
    
    public static void main(String[] args) {

        SparkConf conf = new parkConf().setMaster("local[*]").setAppName("AvgApp");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);

        JavaRDD<String> input = sparkContext.textFile("fileContainingNumbers.txt");
        JavaRDD<String> numberStrings = input.flatMap(strVal -> Arrays.asList(strVal.split(" ")).iterator());
        JavaRDD<String> onlyNumbers= numberStrings.filter(s -> !s.isEmpty());
	  double count = (double) onlyNumbers.count();     
  	JavaRDD<Double> convertedNumbers= onlyNumbers.map(no -> Integer.valueOf(no)/count);
	     	
	double avg= convertedNumbers.reduce((x,y) -> x+y);

        System.out.println("Total avg is: " + avg);

        sparkContext.close();
    }
}
