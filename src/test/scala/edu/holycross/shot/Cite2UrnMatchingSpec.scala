
package edu.holycross.shot.cite


import org.scalatest.FlatSpec

class Cite2UrnMatchingSpec extends FlatSpec {

  "Cite2Urn matching" should "match collection values when they are identical" in {
    val u1 = Cite2Urn("urn:cite2:hmt:msA:12r")
    val u2 = Cite2Urn("urn:cite2:hmt:msA:12v")
    assert (u1.collectionsMatch(u2))
    assert (u2.collectionsMatch(u1))
  }

  it should "match collection values when one collection is versioned and the other is not" in {
    val u1 = Cite2Urn("urn:cite2:hmt:msA:12r")
    val u2 = Cite2Urn("urn:cite2:hmt:msA.release1:12v")
    assert (u1.collectionsMatch(u2))
    assert (u2.collectionsMatch(u1))
  }



}
