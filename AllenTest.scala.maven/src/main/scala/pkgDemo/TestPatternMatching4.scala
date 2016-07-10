package pkgDemo

object TestPatternMatching4 extends App {
  sealed abstract class Expression
  case class X() extends Expression
  case class Const(value: Int) extends Expression
  case class Add(left: Expression, right: Expression) extends Expression
  case class Mult(left: Expression, right: Expression) extends Expression
  case class Neg(expr: Expression) extends Expression

  def eval(expression: Expression, xValue: Int): Int = expression match {
    case X() =>
      println("X() = " + xValue);
      xValue
    case Const(cst) =>
      println("Const(" + cst + ") = " + cst);
      cst
    case Add(left, right) =>
      println("Add(" + left + ", " + right + ")");
      val add = eval(left, xValue) + eval(right, xValue)
      println("Add(" + left + ", " + right + ") = " + add);
      add
    case Mult(left, right) =>
      println("Mult(" + left + ", " + right + ")");
      val mult = eval(left, xValue) * eval(right, xValue)
      println("Mult(" + left + ", " + right + ") = " + mult);
      mult
    case Neg(expr) =>
      println("Neg(" + expr + ")");
      val neg = -eval(expr, xValue)
      println("Neg(" + expr + ") = " + neg);
      neg
  }
  //  val expr = Add(Const(1), Mult(Const(2), Mult(X(), X()))) // 1 + 2 * X * X
  //  val value = eval(expr, 3)
  //  assert(value == 19)
  //  println(value)

  def deriv(expression: Expression): Expression = expression match {
    case X() => Const(1)
    case Const(_) => Const(0)
    case Add(left, right) => Add(deriv(left), deriv(right))
    case Mult(left, right) => Add(Mult(deriv(left), right), Mult(left, deriv(right)))
    case Neg(expr) => Neg(deriv(expr))
  }

  // = 0 + (0 * X*X + 2 * (1*X + X*1)) = 4 * X
  //  val expr = Add(Const(0), Add(Mult(Const(0), Mult(X(), X())), Mult(Const(2), Add(Mult(Const(1), X()), Mult(X(), Const(1))))))
  // = (X*X + 2 * (X + X)) = 4 + 2 * X
  val expr = Add(Mult(X(), X()), Mult(Const(2), Add(X(), X())))
  val ret = eval(deriv(expr), 3)
  println((deriv _) + "(" + expr + ", 3) = " + ret) // 12
}
 