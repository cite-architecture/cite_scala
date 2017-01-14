// You need to have a resolver for UH to do this:
import edu.holycross.shot.cite._

def view (urnString: String) = {
  val urn = Cite2Urn(urnString)
  println(urn.debugString.mkString("\n"))
}
