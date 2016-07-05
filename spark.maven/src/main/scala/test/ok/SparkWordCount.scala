package test.ok

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark._
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
object SparkWordCount {
  def main(args: Array[String]) {
    val sc = new SparkContext("local", "Word Count", "/usr/local/spark", Nil, Map(), Map())
    /* local = master URL; Word Count = application name; */
    /* /usr/local/spark = Spark Home; Nil = jars; Map = environment */
    /* Map = variables to work nodes */
    /*creating an inputRDD to read text file (in.txt) through Spark context*/
    val input = sc.textFile("C:\\temp\\input.txt")
    /* Transform the inputRDD into countRDD */
    val count = input.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    /* saveAsTextFile method is an action that effects on the RDD */
    println(count.toString());
    //   count.saveAsTextFile("c:\\temp\\_output.txt")
    System.out.println("OK");
    sc.stop();
  }
}