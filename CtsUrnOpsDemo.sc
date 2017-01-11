// You need to have a resolver for UH to do this:
import edu.holycross.shot.cite._

def demoOps(u: CtsUrn) {
  println("\tAs submitted: " + u)
  println("\tDrop subreferences: " + u.dropSubref)
  println("\tDrop passage component: " + u.dropPassage)
}

def ops(s1: String, s2: String = "") {
  val u1 = CtsUrn(s1)

  if (s2.isEmpty) {
    println("\nCTS URN " + u1)
    demoOps(u1)
    
  } else {
    val u2 = CtsUrn(s2)
    println("\nFirst CTS URN " + u1)
    demoOps(u1)
    println("\n\nSecond CTS URN " + u2)
    demoOps(u2)
    println("\nURNs match? " + u1.urnMatch(u2))
  }
}
