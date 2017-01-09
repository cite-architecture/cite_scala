package edu.holycross.shot.cite

import org.scalatest.FlatSpec



class CtsUrnSpec extends FlatSpec {
  "A CTS URN" should "be constructed from a String" in {
    val iliadString = "urn:cts:greekLit:tlg0012.tlg001:"
    val iliadUrn = CtsUrn(iliadString)
    iliadUrn match {
      case u: CtsUrn => assert(1 == 1)
      case _ => fail("Did not construct a CtsUrn object from " + iliadString)
    }
  }

}
