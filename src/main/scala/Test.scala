package code

import scala.tools.scalap.scalax.rules.scalasig._

case class Test(name: String)

class Booyan(base: Int)
class Booyak(base: String)
class Booyap(base: java.lang.Object)

object Test extends App {
  printClass(classOf[Booyan])
  printClass(classOf[Booyak])
  printClass(classOf[Booyap])

  def printClass(clazz: Class[_]) = {
    println(
      ScalaSigParser
        .parse(clazz)
        .get
        .symbols
        .collect {
          case initSymbol: MethodSymbol if initSymbol.name == "<init>" =>
            initSymbol.name + ": " + initSymbol.children
        }
        .mkString(" - ", "\n - ", "")
    )
  }
}
