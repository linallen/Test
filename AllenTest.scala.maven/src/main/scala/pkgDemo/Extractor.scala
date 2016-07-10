package pkgDemo

object Extractor extends App {
  println("Apply method : " + apply("Zara", "gmail.com"));
  println("Unapply method : " + unapply("Zara@gmail.com"));
  println("Unapply method : " + unapply("Zara Ali"));

  // The injection method (optional)
  def apply(user: String, domain: String) = {
    user + "@" + domain
  }

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  println("show(capitals.get( \"Japan\")) : " +
    show(capitals.get("Japan")))
  println("show(capitals.get( \"India\")) : " +
    show(capitals.get("India")))
}