package test.scala.maven

import allen.arff._;

object Main {

  def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def main(args: Array[String]) {
    println("Hello Scala built with Maven, Allen!")
    // Arff
    val arff = new Arff();
    arff.load("c:/temp/train.arff");
    println("arff: " + arff.toString());
  }
}