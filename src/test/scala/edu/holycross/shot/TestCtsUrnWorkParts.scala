
package edu.holycross.shot.cite

// Modelled on examples in this blog post:
//http://blog.scalac.io/2015/03/27/specs2-notes.html
//
// I've still got tons to learn about specs2.
//
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class TestCtsUrnWorkParts extends Specification {
  class Context extends Scope {
    val groupLevel = CtsUrn("urn:cts:greekLit:tlg0012:")
    val workLevel = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001:")
    val versionLevel = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:")
    val exemplarLevel = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA.lextokens:")

  }

  "The URN 'urn:cts:greekLit:tlg0012:'" should {
    "have a text group" in new Context {
      groupLevel.textGroup == "tlg0012"
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012:'" should {
    "have an empty string for work" in new Context {
      groupLevel.work == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012:'" should {
    "have an empty string for version" in new Context {
      groupLevel.version == ""
    }
  }
  "The URN 'urn:cts:greekLit:tlg0012:'" should {
    "have an empty string for exemplar" in new Context {
      groupLevel.exemplar == ""
    }
  }


  "The URN urn:cts:greekLit:tlg0012.tlg001:" should {
    "have a text group" in new Context {
      workLevel.textGroup == "tlg0012"
    }
  }
  "The URN urn:cts:greekLit:tlg0012.tlg001:" should {
    "have a work" in new Context {
      workLevel.work == "tlg001"
    }
  }
  "The URN urn:cts:greekLit:tlg0012.tlg001:" should {
    "have an empty string for version" in new Context {
      workLevel.version == ""
    }
  }
  "The URN urn:cts:greekLit:tlg0012.tlg001:" should {
    "have an empty string for exemplar" in new Context {
      workLevel.exemplar == ""
    }
  }


}
