package edu.holycross.shot.cite

import org.scalatest.FlatSpec

class CtsUrnWorkSpec extends FlatSpec {

  "The work component of a CtsUrn" should "always have a text group identifier" in {
    val groupLevel = CtsUrn("urn:cts:greekLit:tlg0012:")
    assert(groupLevel.textGroup == "tlg0012")
  }

  it should "have an empty work option if no work is given" in {
    val groupLevel = CtsUrn("urn:cts:greekLit:tlg0012:")
    groupLevel.workOption match {
      case None => assert(1 == 1)
      case _ => fail("Incorrect option for work")
    }
  }

  it should "retrieve a string value for a work identifier" in {
    val workLevel = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001:")
    assert(workLevel.work == "tlg001")
  }
  /*
  class Context extends Scope {
    val groupLevel = CtsUrn("urn:cts:greekLit:tlg0012:")

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
*/

}
