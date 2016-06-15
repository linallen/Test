package pkgScalaTour

import scala.collection.JavaConversions._

import allen.base.common._
import allen.base.module._

object DemoArrayList extends AAI_Module {
  def main(args: Array[String]) {
    var jList = new java.util.ArrayList[String]()
    jList.add("Ikenna"); jList.add("okpala"); jList.add("kengimel"); jList.add("Scala"); jList.add("Java")
    println(jList)
    val slist = scala.collection.JavaConversions.asScalaBuffer(jList)
    // val slist = scala.collection.JavaConversions.asBuffer(jList)
    println(slist)
    println(jList)
    println(Common.quote("Hello World"))
    System.out.println(Common.quote("Hello System"))
    name("Allen Lin");
    println(name())
  }
}