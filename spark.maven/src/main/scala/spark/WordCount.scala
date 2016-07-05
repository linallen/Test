package spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

class WordCount {
  def run() {
    println("started\n")
    val conf = new SparkConf().setAppName("MySparkDriverApp").setMaster("spark://master:7077").set("spark.executor.memory", "2g")
    println(conf)

    val fileName = "c:\\_Test\\input.txt"
    val sc = new SparkContext("local[4]", "Allen's Word Count", "/usr/local/spark", Nil, Map(), Map())
    val str = sc.toString()
    println(str)

    ///////////////////////////////////
    //    val lines = sc.textFile(fileName)
    //    val lineLengths = lines.map(s => s.length)
    //    val totalLength = lineLengths.reduce((a, b) => a + b)

    ///////////////////////////////////
    //    val data = Array(1, 2, 3, 4, 5)
    //    val distData = sc.parallelize(data)
    //    println(distData)
    //    val res = distData.reduce((a, b) => a + b)
    //    println(res)
    ///////////////////////////////////
    println("finished")

    ///////////////////////////////////
    val inputfile = sc.textFile(fileName)
    for (i <- 1 to 100) {
      val counts = inputfile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _);
      counts.cache()
      counts.saveAsTextFile("c:\\_Test\\output" + i)
      println(i + "\n" + counts.toDebugString)
      Thread.sleep(1000)
    }
    println("finished")
    Thread.sleep(1000000)
  }
}