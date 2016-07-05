package spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WC {
  def main(args: Array[String]) {
    println("started\n")
    val conf = new SparkConf().setAppName("MySparkDriverApp").setMaster("spark://master:7077").set("spark.executor.memory", "2g")
    println(conf)

    val workDir = "c:\\_Test\\"
    val inputFileName = workDir + "input.txt"
    val inputFileName2 = workDir + "input2.txt"
    val sc = new SparkContext("local[4]", "Allen's Word Count", "/usr/local/spark", Nil, Map(), Map())

    val NUM_SAMPLES = 100000
    val mapped = sc.parallelize(1 to NUM_SAMPLES).map { i =>
      val x = Math.random()
      val y = Math.random()
      if (x * x + y * y < 1) 1 else 0
    }
    // mapped.foreach { println }
    var length = 0
    for (i <- mapped) {
      length += 1
    }
    println("length = " + length)
    println("mapped: " + mapped.toDebugString)
    val count = mapped.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / NUM_SAMPLES)

    ////////////////////////////////////////
    val textFile = sc.textFile(inputFileName)
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.foreach(println)
    val outputFile = workDir + "output"
    println(outputFile)
    //counts.saveAsTextFile(outputFile)

    ///////////////////////////////////
    val lines = sc.textFile(inputFileName)
    lines.foreach { x => println(x) }
    println(" count = " + lines.count())
    val lineLengths = lines.map(s => s.length)
    val totalLength = lineLengths.reduce((a, b) => a + b)
    lineLengths.foreach { x => println(x) }
    println(" lineLengths = " + lineLengths)
    println(" totalLength = " + totalLength)
    ///////////////////////////////////

    val linesNew = lines.map { x => "_" + x + "_" }
    linesNew.foreach { x => println(x) }

    ///////////////////////////////////
    val char = 'o'
    def count_char(text: String) = Func.count(text, char)
    val num_a = count_char("abcdefgades")
    val lines2 = linesNew.map { count_char }
    lines2.collect().foreach { println }
    lines2.take(3).foreach { println }
    val total = lines2.reduce(_ + _)
    println(" total number of \'" + char + "\' = " + total)
    //    lines2.cache()
    //    lines2.saveAsTextFile("c:\\_Test\\count_" + char)

    ///////////////////////////////////
    val data = Array(1, 2, 3, 4, 5)
    val distData = sc.parallelize(data)
    println(distData)
    val res = distData.reduce((a, b) => a + b)
    println("res = " + res)
    ///////////////////////////////////

    println("finished")

    ///////////////////////////////////
    //    val inputfile = sc.textFile(inputFileName2)
    //    val counts = inputfile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _);
    //    counts.cache()
    //    counts.saveAsTextFile(workDir + "count")
    println("finished")
    sc.stop()
  }
}

/** return the number of 'char' in "text" */
object Func {
  def count(text: String, char: Char): Int = {
    text.count { _ == char }
  }
}