package pkgTest2

import java.io._

object Demo {
  def main(args: Array[String]) {
    //val writer:PrintWriter = null;
    try {
      val file = new File("D:/_Test/Demo.txt");
      val writer = new PrintWriter(file);
      writer.write("Hello Scala");
      writer.close();
    } catch {
      case ex: Exception => { print("Exception") }
      case ex: FileNotFoundException => { println("Missing file exception") }
      case ex: IOException => { println("IO Exception") }
    }
    print("\nAll done");
  }
}