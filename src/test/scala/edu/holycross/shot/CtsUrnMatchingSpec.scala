package edu.holycross.shot.cite

import org.scalatest.FlatSpec



class CtsUrnMatchingSpec extends FlatSpec {


  "CTS URN matching" should "match identical passages when level of hierarchy differs" in pending /*(){
    val iliadUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1")
    val editionUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1")

    assert  (iliadUrn.urnMatch(editionUrn))
  }*/

  it should "determine if a passage reference in one URN appears in the passage hierarchy of another URN" in {
    val highLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA.hmt:1.1")
    val lowLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA.hmt:1.1.lemma")
    assert(lowLevel.passageContainedIn(highLevel))
  }
  it should "determine if either of two URNs' passage reference is contained by the either" in {
    val highLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA.hmt:1.1")
    val lowLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA.hmt:1.1.lemma")
    assert(lowLevel.passageMatch(highLevel))
    assert(highLevel.passageMatch(lowLevel))
  }

  it should "determine if a work reference in one URN appears in the work hierarchy of another URN" in {
    val highLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA:1.1")
    val lowLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA.hmt:1.1")
    assert(lowLevel.workContainedIn(highLevel))
  }
  it should "determine if either of two URNs' work reference is contained by the either" in {
    val highLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA:1.1")
    val lowLevel = CtsUrn("urn:cts:greekLit:tlg5026.msA.hmt:1.1")
    assert(lowLevel.workMatch(highLevel))
    assert(highLevel.workMatch(lowLevel))
  }
}
