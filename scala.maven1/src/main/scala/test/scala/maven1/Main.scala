package test.scala.maven1

object Main {

  def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def main(args: Array[String]) {
    println("Hello Scala built with Maven!")
  }
}