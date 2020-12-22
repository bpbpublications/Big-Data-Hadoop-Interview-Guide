public class SumCalculateSpark{
    
    public static void main(String[] args) {
       SparkConf conf = new parkConf().setMaster("local[*]").setAppName("SumApp");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);

        JavaRDD<String> input = sparkContext.textFile("fileContainingNumbers.txt");
        JavaRDD<String> numberStrings = input.flatMap(strVal -> Arrays.asList(strVal.split(" ")).iterator());
        JavaRDD<String> onlyNumbers= numberStrings.filter(s -> !s.isEmpty());
        JavaRDD<Integer> convertedNumbers= onlyNumbers.map(no -> Integer.valueOf(no));
        int totolSum= convertedNumbers.reduce((x,y) -> x+y);

        System.out.println("Total sum is: " + totolSum);
        sparkContext.close();
    }
}
