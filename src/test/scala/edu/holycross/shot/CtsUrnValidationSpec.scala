package edu.holycross.shot.cite

import org.scalatest.FlatSpec

class CtsUrnValidationSpec extends FlatSpec {

  "A Cts Urn constructor" should "throw an IllegalArgumentException if the the URN string has too few components" in {
    try {
      CtsUrn("urn:cts:greekLit:tlg0012.tlg001")
    } catch {
      case ex : IllegalArgumentException => assert(ex.getMessage() == "requirement failed: invalid URN syntax: urn:cts:greekLit:tlg0012.tlg001. Wrong number of components.")
    }
   }

   it should "throw an IllegalArgumentException if the `urn` component is missing" in {
    try {

    CtsUrn("XX:cts:greekLit:tlg0012.tlg001:")
    } catch {
      case e: IllegalArgumentException => assert (e.getMessage() == "requirement failed: invalid URN syntax: XX:cts:greekLit:tlg0012.tlg001:. First component must be 'urn'.")
    }
   }
   /*
 }

 "A CtsUrn" should {
  "throw an IllegalArgumentException if 'urn' component is missing" in {

     must  throwA[java.lang.IllegalArgumentException]
    }
  }

  "A CtsUrn" should {
    "throw an IllegalArgumentException if required 'cts' component is missing" in {
     CtsUrn("urn:XX:greekLit:tlg0012.tlg001:") must  throwA[java.lang.IllegalArgumentException]
    }
  }

  "A CtsUrn" should {
    "throw an IllegalArgumentException if work hierarchy exceeds 4 levels" in {
     CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA.tokens.subexemplar:") must  throwA[java.lang.IllegalArgumentException]
    }
  }

  "A CtsUrn" should {
    "throw a scala.MatchError if a range has more than two elements" in {
     CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.10-1.17") must  throwA[scala.MatchError]
    }
  }

  "A CtsUrn" should {
    "throw an IllegalArgumentException if a range has an empty beginning node" in {
     CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:-1.10") must  throwA[java.lang.IllegalArgumentException]
    }
  }

  "A CtsUrn" should {
    "throw an IllegalArgumentException if a range has an empty ending node" in {
     CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-") must  throwA[java.lang.IllegalArgumentException]
    }
  }*/

}
