package pkgDemo

object TestPatternMatching2 extends App {
  def matchTest(x: Any): Any = x match {
    case a if 0 to 9 contains a => println("0-9 range: " + a)
    case a if 10 to 19 contains a => println("10-19 range: " + a)
    case a if 20 to 29 contains a => println("20-29 range: " + a)
    case _ => println("Hmmm...")
  }
  matchTest(12)

  def func(x: Int, y: Int): String = (x, y) match {
    case (_, 0) | (0, _) => "Zero"
    case (x, _) if x > -1 => "Positive number"
    case (_, y) if y < 0 => "Negative number"
    case (_, _) => "Could not classify"
  }

  println(func(10, -1))
  println(func(-10, 1))
  println(func(-10, 0))
}
 