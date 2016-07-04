package pkgScalaTour

//import net.liftweb._
trait ForEachAble[A] {
  def iterator: java.util.Iterator[A]
  def foreach(f: A => Unit) = {
    val iter = iterator
    while (iter.hasNext)
      f(iter.next)
  }
}

trait JsonAble {
  def toJson() = println("aa");
}

object DemoTraits {

  def main(args: Array[String]) {
    val list = new java.util.ArrayList[Int]() with ForEachAble[Int]
    list.add(1); list.add(2)

    println("For each: "); list.foreach(x => println(x))
    //println("Json: " + list.toJson())
  }

}