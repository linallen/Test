package test.spark.maven

object App {

  def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def main(args: Array[String]) {
    println("Hello Spark")
  }
}