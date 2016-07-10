package pkgScalaTour

import java.util.ArrayList;

object FuncDemo {
  def main(args: Array[String]) {
    def squareO(a: Int) = a * a
    def squareB(a: Int) = { a * a }
    val squareV = (a: Int) => a * a
    def addOne(f: Int => Int, arg: Int) = f(arg) + 1

    println("squareO(2):" + squareO(2))
    println("squareB(2):" + squareB(2))
    println("squareV(2):" + squareV(2))
    println("addOne(squareV,2):" + addOne(squareB, 2))

    var test = new ArrayList[Integer]()
  }
}