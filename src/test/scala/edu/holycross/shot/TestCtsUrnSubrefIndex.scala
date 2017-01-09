
package edu.holycross.shot.cite

// Modelled on examples in this blog post:
//http://blog.scalac.io/2015/03/27/specs2-notes.html
//
// I've still got tons to learn about specs2.
//
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

  class TestCtsUrnSubrefIndex extends Specification {

  class Context extends Scope {

    val noSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
    val psgSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath")
    val psgSubrefIndexed = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]")
    val badSubrefIndexed = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[i]")


    val rangeBeginIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.10")
    val rangeEndIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.2@dogs[1]")

    val rangeBothIndexedSubref = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1@wrath[1]-1.2@dogs[1]")
  }

  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1'" should {
    "have a None value of subref index" in new Context {
      noSubref.passageNodeSubrefIndex match {
        case Some(i) => false
        case None => true
      }
    }
  }

  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath'" should {
    "have a None value for subref index" in new Context {
      psgSubref.passageNodeSubrefIndex match {
        case Some(i) => false
        case None => true
      }
    }
  }

  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]'" should {
    "have a subref index of 1" in new Context {
      psgSubrefIndexed.passageNodeSubrefIndex match {
        case 1 =>  true
        case _ => false
      }
    }
  }

  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[i]'" should {
    "have a None value of subref index" in new Context {
      badSubrefIndexed.passageNodeSubrefIndex match {
        case Some(i) => false
        case None => true
      }
    }
  }



  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]-1.10'" should {
    "have a subref index of 1 for range begin" in new Context {
      rangeBeginIndexedSubref.rangeBeginSubrefIndex match {
        case 1 =>  true
        case _ => false
      }
    }
  }


  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1@wrath[1]-1.10'" should {
    "have a value of None for range end index" in new Context {
      rangeBeginIndexedSubref.rangeEndSubrefIndex match {
        case Some(i) =>  true
        case None => false
      }
    }
  }



  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1-1.2@dogs[1]]'" should {
    "have an index of 1 for range end index" in new Context {
      rangeEndIndexedSubref.rangeEndSubrefIndex match {
        case 1 =>  true
        case _ => false
      }
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1-1.2@dogs[1]]'" should {
    "have a value of None for range begin index" in new Context {
      rangeBeginIndexedSubref.rangeEndSubrefIndex match {
        case Some(i) =>  false
        case None => true
      }
    }
  }


  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1wrath[1]-1.2@dogs[1]]'" should {
    "have a subref index of 1 for range begin" in new Context {
      rangeBothIndexedSubref.rangeBeginSubrefIndex match {
        case 1 =>  true
        case _ => false
      }
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012.tlg.001:1.1wrath[1]-1.2@dogs[1]]'" should {
    "have a subref index of 1 for range end" in new Context {
      rangeBothIndexedSubref.rangeEndSubrefIndex match {
        case 1 =>  true
        case _ => false
      }
    }
  }
}
