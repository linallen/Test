package pkgTutorial

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Test extends App {
  val sc = new SparkContext("local", "Word Count", "/usr/local/spark", Nil, Map(), Map())
  val str = sc.toString()
  println(str)
  val inputfile = sc.textFile("c:\\_Test\\input.txt")
  val counts = inputfile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _);
  counts.toDebugString
  counts.cache()
  counts.saveAsTextFile("c:\\_Test\\output.txt")
}