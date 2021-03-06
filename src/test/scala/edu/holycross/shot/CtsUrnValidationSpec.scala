package edu.holycross.shot.cite

import org.scalatest.FlatSpec

class CtsUrnValidationSpec extends FlatSpec {

  "A Cts Urn constructor" should "construct a URN object from a well-formed string" in {
    val iliadString = "urn:cts:greekLit:tlg0012.tlg001:"
    val iliadUrn = CtsUrn(iliadString)
    iliadUrn match {
      case u: CtsUrn => assert(true)
      case _ => fail("Did not construct a CtsUrn object from " + iliadString)
    }
  }

  it should "throw an IllegalArgumentException if the the URN string has too few components" in {
    try {
      CtsUrn("urn:cts:greekLit:tlg0012.tlg001")
    } catch {
      case ex : IllegalArgumentException => assert(ex.getMessage() == "requirement failed: invalid URN syntax: urn:cts:greekLit:tlg0012.tlg001. Wrong number of components.")
      case unknown: Throwable => fail("Unrecognized exception " + unknown)
    }
   }

   it should "throw an IllegalArgumentException if the the URN string has too many components" in {
     try {
       CtsUrn("urn:cts:greekLit:tlg0012:tlg001:")
     } catch {
       case ex : IllegalArgumentException => assert(ex.getMessage() == "requirement failed: invalid URN syntax: urn:cts:greekLit:tlg0012.tlg001. Wrong number of components.")
     }
  }

  it should "throw an IllegalArgumentException if the `urn` component is missing" in {

    try {
      CtsUrn("XX:cts:greekLit:tlg0012.tlg001:")
    } catch {
      case e: IllegalArgumentException => assert (e.getMessage() == "requirement failed: invalid URN syntax: XX:cts:greekLit:tlg0012.tlg001:. First component must be 'urn'.")
      case unknown: Throwable => fail("Unrecognized exception " + unknown)
    }
  }
  it should "throw an IllegalArgumentException if the `cts` component is missing" in {
    try {
      CtsUrn("urn:XXX:greekLit:tlg0012.tlg001:")
    } catch {
      case e: IllegalArgumentException => assert (e.getMessage() == "requirement failed: invalid URN syntax: urn:XXX:greekLit:tlg0012.tlg001:. Second component must be 'cts'.")
    }
  }

  // Syntax of work component:
  it should "guarantee that the work component is non-empty" in {
    val iliad = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:")
    assert (iliad.workComponent.nonEmpty)
  }
  it should "throw an IllegalArgumentException if a work component has more than 4 parts" in {
    try {
     CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA.tokens.subexemplar:")
   } catch {
     case e: IllegalArgumentException => assert(e.getMessage() == "requirement failed: invalid URN syntax. Too many parts in work component tlg0012.tlg001.msA.tokens.subexemplar")
     case unknown: Throwable => fail("Unrecognized exception " + unknown)
   }
  }


  // Syntax of passage component:
  it should "throw an IllegalArgumentException if a range has an empty first node" in {
    try {
      CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:-1.10")
    } catch {
      case e: IllegalArgumentException => assert (e.getMessage() == "requirement failed: Invalid URN syntax.  Error in passage component -1.10")
      case unknown: Throwable => fail("Unrecognized exception " + unknown)
    }
  }
  it should "throw an IllegalArgumentException if a range has an empty second node" in {
    try {
      CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-")
    } catch {
      case e: IllegalArgumentException => assert (e.getMessage() == "requirement failed: Invalid URN syntax.  Error in passage component 1.1-")
      case unknown: Throwable => fail("Unrecognized exception " + unknown)
    }
  }
  it should "throw a CiteException if a range has more than two elements" in {
    try {
     CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.10-1.17")
   } catch {
     case e: CiteException => assert(e.message == "invalid URN string: more than two elements in range 1.1-1.10-1.17")
     case unknown: Throwable => fail("Unrecognized exception " + unknown)
   }
  }
  it should "identify a range reference as a range and not a node" in {
    val rangeUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.10")
    assert (rangeUrn.isRange)
    assert (! rangeUrn.isPoint)
  }
  it should "identify a node reference as a node and not a range" in {
    val pointUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.10")
    assert (! pointUrn.isRange)
    assert (pointUrn.isPoint)
  }
  it should "throw an exception if there are empty components within a passage reference" in {
    try {
     val urn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1...10")
     fail("Should not have created urn " + urn)
   } catch {
     case e: IllegalArgumentException => assert(e.getMessage() == "requirement failed: invalid passage syntax in urn:cts:greekLit:tlg0012.tlg001.msA:1...10")
     case otherE: Throwable => throw CiteException("Unexpected exception: " + otherE)
   }
  }


  it should "throw an exception if there are empty components within the first node of a range reference" in {
    try {
     val urn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1...1-1.7")
     fail("Should not have created urn " + urn)
   } catch {
     case e: IllegalArgumentException => assert(e.getMessage() == "requirement failed: invalid passage syntax in range beginning of urn:cts:greekLit:tlg0012.tlg001.msA:1...1-1.7")
     case otherE: Throwable => throw CiteException("Unexpected exception: " + otherE)
   }
  }
  it should "throw an exception if there are empty components within the second node of a range reference" in {
    try {
     val urn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1...7")
     fail("Should not have created urn " + urn)
   } catch {
     case e: IllegalArgumentException => assert(e.getMessage() == "requirement failed: invalid passage syntax in range ending of urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1...7")
     case otherE: Throwable => throw CiteException("Unexpected exception: " + otherE)
   }
  }

  it should "throw an exception if there are empty components within the work reference" in {
    try {
      val urn = CtsUrn("urn:cts:greekLit:tlg0012..tlg001:1.1")
      fail("Should not have created urn " + urn)
      } catch {
        case e: IllegalArgumentException => assert(e.getMessage() == "requirement failed: invalid work syntax in urn:cts:greekLit:tlg0012..tlg001:1.1")
      }
  }
  it should "throw an exception if there are leading periods in the passage component" in pending
  it should "throw an exception if there are trailing periods in the passage component" in pending

  it should "throw an exception if there are leading periods in the range beginning part" in pending
  it should "throw an exception if there are trailing periods in the range beginning part" in pending

  it should "throw an exception if there are leading periods in the range ending part" in pending
  it should "throw an exception if there are trailing periods in the range ending part" in pending

}
