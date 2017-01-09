package edu.holycross.shot.cite

import org.scalatest.FlatSpec



class CtsUrnOpsSpec extends FlatSpec {


  "A CTS URN with passage component" should "allow dropping the passage component" in {
    val iliadUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1")
    assert  (iliadUrn.dropPassage == CtsUrn("urn:cts:greekLit:tlg0012.tlg001:"))
  }

  "A CTS URN with subreference" should "allow striping off subreference" in {
    val iliadUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1@μῆνιν")
    assert  (iliadUrn.dropSubref == CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1"))
  }

  "A CTS URN with subreference on a range node" should "allow striping off subreference" in {
    val iliadUrn = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1@μῆνιν-1.2")
    assert  (iliadUrn.dropSubref == CtsUrn("urn:cts:greekLit:tlg0012.tlg001:1.1-1.2"))
  }

}
