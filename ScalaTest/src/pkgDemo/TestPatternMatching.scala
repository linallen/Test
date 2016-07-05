package pkgDemo

object TestPatternMatching {
  def main(args: Array[String]) {
    def fibonacci(in: Any): Int = in match {
      case 0 => 0
      case 1 => 1
      case n: Int => fibonacci(n - 1) + fibonacci(n - 2)
      case _ => 0
    }
    println(fibonacci(3))
    //println(fibonacci(-3))
    //println(fibonacci("3"))
  }
}