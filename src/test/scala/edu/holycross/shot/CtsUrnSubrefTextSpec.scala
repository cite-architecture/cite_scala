
package edu.holycross.shot.cite


import org.scalatest.FlatSpec


class CtsUrnSubrefTextSpec extends FlatSpec {

  "A Cts URN" should "have the text part of a passage node subreference equal to the subreference when no index is defined" in  pending /*{




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
*/
  it should "have a string value for a passage node subreference text content when the subref includes an explicit index" in pending/* {
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
*/
  it should "throw a Cite exception when trying to retrieve non-existent passage node subreference text content" in pending /*  {
      val noSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
      try {
        noSubref.passageNodeSubref
      } catch {
        case citeEx: CiteException => assert(citeEx.message == "No individual node subref defined in urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
        case ex: Throwable => fail("Unrecognized exception " + ex)
      }
  }
  */
  it should "have a string value for subreference text on the first node of a range without index" in pending /*{
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
*/
  it should "have a string value for the subreference text on the first node of a range when a subref includes an explicit index" in pending
  it should "throw a Cite exception when trying to retrieve non-existent subreference text content on the first node of a range" in pending



  it should "have a string value for subreference text on the second node of a range without index" in pending
  it should "have a string value for the subreference text on the second node of a range when a subref includes an explicit index" in pending
  it should "throw a Cite exception when trying to retrieve non-existent subreference text content on the second node of a range" in pending



  it should "have string values for subreference text on both nodes of a range without index" in pending
  it should "have string values for the subreference text on both nodes of a range when the subrefs includes an explicit index" in pending
  it should "throw a Cite exception when trying to retrieve non-existent subreference text content on the either node of a range" in pending



}
