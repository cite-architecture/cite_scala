package edu.holycross.shot.cite

import org.scalatest.FlatSpec



class CtsUrnConstructorSpec extends FlatSpec {
  "A CTS URN" should "be constructed from a well-formed URN string" in {
    val iliadString = "urn:cts:greekLit:tlg0012.tlg001:"
    val iliadUrn = CtsUrn(iliadString)
    iliadUrn match {
      case u: CtsUrn => assert(1 == 1)
      case _ => fail("Did not construct a CtsUrn object from " + iliadString)
    }
  }
  // add tests for various forms of bad string input
}
