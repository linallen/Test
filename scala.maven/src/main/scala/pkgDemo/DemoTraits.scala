package pkgDemo

//trait ForEachAble[A] {
//  def iterator: java.util.Iterator[A]
//  def foreach(f: A => Unit) = {
//    val iter = iterator
//    while (iter.hasNext)
//      f(iter.next)
//  }
//}

trait ForEachAble[A] {
  def iterator: java.util.Iterator[A];
  def foreach(f: A => Unit) = {
    val iter = iterator
    while (iterator.hasNext) {
      f(iterator.next)
    }
  }
}

trait JsonAble {
  def toJson() = println("aa");
}

object DemoTraits {

  def main(args: Array[String]) {
    val list = new java.util.ArrayList[Int]() with ForEachAble[Int]
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    println("start");
    list.foreach(x => println(x + "_"))
    println("end");
    //println("Json: " + list.toJson())
  }
}