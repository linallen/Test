package spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql._

object TestDataFrame {
  def main(args: Array[String]) {
    println("started\n")
    val sc = new SparkContext("local[4]", "Allen's Word Count", "/usr/local/spark", Nil, Map(), Map())
    val sqlContext = new SQLContext(sc)
    println(sqlContext.toString())
    
    val df = sqlContext.jsonFile("D:/GoogleDrive/UTS/SourceCode/_MyTest/spark-master/examples/src/main/resources/people.json")

    // Displays the content of the DataFrame to stdout
    df.show()

    // Counts people by age
    val countsByAge = df.groupBy("age").count()
    countsByAge.show()

    println(countsByAge.toString())

    // Saves countsByAge to S3 in the JSON format.
    //        countsByAge.write.format("json").("file:/D://_Test/output_1")
    //    countsByAge.write.format("json").save("file:/D://_Test/output_1")

    println("finished")
    sc.stop()
  }
}