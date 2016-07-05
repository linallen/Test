package pkgDemo

object TestList extends App {
  val diffList = List(1, 2, 3, 4) diff List(2, 3) //> diffList = List(1, 4)  
  println(diffList)
}