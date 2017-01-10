
package edu.holycross.shot.cite


import org.scalatest.FlatSpec

class CtsUrnStructureSpec extends FlatSpec {
  val simplePassageUrn = CtsUrn( "urn:cts:greekLit:tlg0012.tlg001.msA:1.1")
  val simpleRangeUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:1.1-1.10")

  "A CtsUrn" should "have a namespace" in {
    assert(simplePassageUrn.namespace == "greekLit")
  }
  it should "have a hierarchical work component" in {
    assert(simplePassageUrn.workComponent == "tlg0012.tlg001.msA")
  }
  it should "determine the level of the work component" in {
    assert(simplePassageUrn.workLevel == WorkLevel.Version)
  }
  /*



  "The urn 'urn:cts:greekLit:tlg0012.tlg001.msA:1.1' " should {
    "have a passage component" in new Context {
      psgNode.passageComponent == "1.1"
    }
  }

  "The passage node 1.1" should {
    "not be a range" in new Context {
      psgNode.isRange == false
    }
  }

  "The passage node 1.1-1.10" should {
    "be a range" in new Context {
      rangeNode.isRange == true
    }
  }
  // etc etc etc  Many units to implement...
*/
}
