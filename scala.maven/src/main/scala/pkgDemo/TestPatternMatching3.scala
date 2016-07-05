package pkgDemo

object TestPatternMatching3 extends App {
  def fact(n: Int): Int = n match {
    case x if x < 0 => 1
    case 0 => 1
    case _ => n * fact(n - 1)
  }
  println(fact(0))
  println(fact(-1))
  println(fact(2))
  println(fact(3))
  println(fact(4))

  def length[A](list: List[A]): Int = list match {
    case _ :: tail => 1 + length(tail)
    case Nil => 0
  }

  val l = length(List(1.2, 2, 3))
  println("length = " + l)

  def parseArgument(arg: String, value: Any): String = (arg, value) match {
    case ("-l", lang) => " -l " + lang
    case ("-o" | "--optim", n: Int) if ((0 < n) && (n <= 5)) => " -o " + n
    case ("-o" | "--optim", badLevel) => " -o bad " + badLevel
    case ("-h" | "--help", str) => "-h help " + str
    case bad => " bad " + bad
  }
  println(parseArgument("-l", "English"))
  println(parseArgument("-o", 4))
  println(parseArgument("-o", 40))
  println(parseArgument("aaa", 22))
  println(parseArgument("--help", " this is a help"))
}
 