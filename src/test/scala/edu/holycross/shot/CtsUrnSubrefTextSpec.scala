
package edu.holycross.shot.cite


import org.scalatest.FlatSpec


class CtsUrnSubrefTextSpec extends FlatSpec {

  "A Cts URN" should "have a none value for all subref indices when no subref is defined" in  pending /*{
    val noSubref = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1")

    noSubref.passageNodeSubrefIndexOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
    noSubref.rangeBeginSubrefIndexOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
    noSubref.rangeEndSubrefIndexOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
  }



  it should "have an integer index of 1 for a passage node when the subref is defined without index" in {
      val psgSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath")

      assert(psgSubref.passageNodeSubrefIndex == 1)

      psgSubref.rangeBeginSubrefIndexOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
      psgSubref.rangeEndSubrefIndexOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
  }

  it should "have an integer value for a passage node subref index when the subref includes an explicit index" in {
      val psgSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]")

      assert(psgSubref.passageNodeSubref == "wrath[1]")

      psgSubref.rangeBeginSubrefOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
      psgSubref.rangeEndSubrefOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
  }

  it should "throw a Cite exception when trying to retrieve a non-existent passage node subref value" in  {
      val noSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
      try {
        noSubref.passageNodeSubref
      } catch {
        case citeEx: CiteException => assert(citeEx.message == "No individual node subref defined in urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
        case ex: Throwable => fail("Unrecognized exception " + ex)
      }
  }
  it should "have a string value for a subref on the first node of a range without index" in {
    val rangeSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath-1.2")

    assert(rangeSubref.rangeBeginSubref == "wrath")

    rangeSubref.passageNodeSubrefOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
    rangeSubref.rangeEndSubrefOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
  }

  it should "have an integer value for a subref index on the first node of a range when a subref includes an explicit index" in pending
  it should "throw a Cite exception when trying to retrieve a non-existent subref index on the first node of a range" in pending



  it should "have an integer value of 1 for a subref index on the second node of a range without index" in pending
  it should "have an integer value for a subref index on the second node of a range when a subref includes an explicit index" in pending
  it should "throw a Cite exception when trying to retrieve a non-existent subref index on the second node of a range" in pending


  it should "have integer values of 1 for subrefs on both nodes of a range without index" in pending
  it should "have integer values for subrefs on both nodes of a range when the subrefs include an explicit index" in pending
  it should "throw a Cite exception when trying to retrieve non-existent subref indices on either node of a range" in pending




    val rangeBothSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath-1.2@dogs")
    val rangeBothIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.2@dogs[1]")
  }

*/




}
