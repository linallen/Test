package pkgScalaTour

object DemoLoan {
  import scala.reflect.io.File
  import java.util.Scanner

  def withScanner(f: File, op: Scanner => Unit) = {
    val scanner = new Scanner(f.bufferedReader)
    try {
      op(scanner)
    } finally {
      scanner.close()
    }
  }
  def main(args: Array[String]) {
    withScanner(File("/proc/self/stat"), scanner => println("pid is " + scanner.next()))
  }
}