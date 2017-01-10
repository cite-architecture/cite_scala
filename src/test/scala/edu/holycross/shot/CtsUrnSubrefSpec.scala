
package edu.holycross.shot.cite


import org.scalatest.FlatSpec


class CtsUrnSubrefSpec extends FlatSpec {

  "A Cts URN" should "have a none value for all subref options when no subref is defined" in {
    val noSubref = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1")

    noSubref.passageNodeSubrefOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
    noSubref.rangeBeginSubrefOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
    noSubref.rangeEndSubrefOption match {
      case None => assert(true)
      case _ => fail("Should not have found a subreference")
    }
  }


    it should "have none options for all subref text and index pieces when there is no subref" in pending/* {
      val noSubref = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1")

      noSubref.passageNodeSubrefTextOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
      noSubref.passageNodeSubrefIndexOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }

      noSubref.rangeBeginSubrefTextOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
      noSubref.rangeBeginSubrefIndexOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }

      noSubref.rangeEndSubrefTextOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
      noSubref.rangeEndSubrefIndexOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }

    }*/

  it should "have a string value for passage node when a subref is defined without index" in {
      val psgSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath")

      assert(psgSubref.passageNodeSubref == "wrath")

      psgSubref.rangeBeginSubrefOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
      psgSubref.rangeEndSubrefOption match {
        case None => assert(true)
        case _ => fail("Should not have found a subreference")
      }
  }

  it should "have a string value for passage node when a subref includes an explicit index" in {
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
  it should "throw a Cite exception when trying to retrieve a non-existent passage subref value" in  {
      val noSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
      try {
        noSubref.passageNodeSubref
      } catch {
        case citeEx: CiteException => assert(citeEx.message == "No individual node subref defined in urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
        case ex: Throwable => fail("Unrecognized exception " + ex)
      }
  }


  /*(){




    val rangeBeginSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath-1.10")
    val rangeBeginIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.10")

    val rangeEndSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs")
    val rangeEndIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs[1]")


    val rangeBothSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath-1.2@dogs")
    val rangeBothIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.2@dogs[1]")
  }



  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have an empty string for subref" in new Context {
      psgSubref.passageNodeSubref == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have an empty string for subref text" in new Context {
      psgSubref.passageNodeSubrefText == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have an empty string for range begin subref" in new Context {
      psgSubref.rangeBeginSubref == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have an empty string for range begin subref text" in new Context {
      psgSubref.rangeBeginSubrefText == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have an empty string for range end subref" in new Context {
      psgSubref.rangeEndSubref == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have an empty string for range end subref text" in new Context {
      psgSubref.rangeEndSubrefText == ""
    }
  }


  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath'" should {
    "have a subref" in new Context {
      psgSubref.passageNodeSubref == "wrath"
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath'" should {
    "have subref text 'wrath'" in new Context {
      psgSubref.passageNodeSubrefText == "wrath"
    }
  }


  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]'" should {
    "have a subref" in new Context {
      psgSubrefIndexed.passageNodeSubref == "wrath[1]"
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]'" should {
    "have subref text 'wrath'" in new Context {
      psgSubrefIndexed.passageNodeSubrefText == "wrath[1]"
    }
  }

  // PICK UP HERE

  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath-1.10'" should {
    "have a subref on the range beginning"in new Context {
      rangeBeginSubref.rangeBeginSubref == "wrath"
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath-1.10'" should {
    "have an empty string for subref on the range end"in new Context {
      rangeBeginSubref.rangeEndSubref == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]-1.10'" should {
    "have a subref on the range beginning"in new Context {
      rangeBeginSubref.rangeBeginSubref == "wrath[1]"
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]-1.10'" should {
    "have an empty string for subref on the range end" in new Context {
      rangeBeginSubref.rangeEndSubref == ""
    }
  }




  "The URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs'" should {
    "have a subref on the range end"in new Context {
      rangeBeginSubref.rangeEndSubref == "dogs"
    }
  }
  "The  URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs'" should {
    "have an empty string for subref on the range beginning" in new Context {
      rangeBeginSubref.rangeBeginSubref == ""
    }
  }

  "The URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs[1]'" should {
    "have an indexed subref on the range end"in new Context {
      rangeBeginSubref.rangeEndSubref == "dogs[1]"
    }
  }
  "The  URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs[1]'" should {
    "have an empty string for subref on the range beginning" in new Context {
      rangeBeginSubref.rangeBeginSubref == ""
    }
  }



  "The URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath-1.2@dogs'" should {
    "have a  subref on the range end"in new Context {
      rangeBothSubref.rangeEndSubref == "dogs"
    }
  }
  "The  URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath-1.2@dogs'" should {
    "have an empty string for subref on the range beginning" in new Context {
      rangeBothSubref.rangeBeginSubref == "wrath"
    }
  }





  "The URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.2@dogs[1]'" should {
    "have an indexed subref on the range end"in new Context {
      rangeBothIndexedSubref.rangeEndSubref == "dogs[1]"
    }
  }
  "The  URN 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.2@dogs[1]'" should {
    "have an empty string for subref on the range beginning" in new Context {
      rangeBothIndexedSubref.rangeBeginSubref == "wrath[1]"
    }
  }
*/
}
