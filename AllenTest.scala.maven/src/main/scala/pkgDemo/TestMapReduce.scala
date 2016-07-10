package pkgDemo

import scala.reflect.io.File
import java.util.Scanner

object Test {

  def main(args: Array[String]) {
    val file = List("warn 2013 msg", "warn 2012 msg msg msg msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val mapped = file.map(wordcount)
    println(mapped)

    val num = file.map(wordcount).reduceLeft(_ + _)

    println("wordcount:" + num)
  }
}