
package edu.holycross.shot.cite


import org.scalatest.FlatSpec

class TestCiteUrnValidation extends FlatSpec {

  "A CiteUrn" should "throw an IllegalArgumentException if too few components" in {
     try {
      CiteUrn("urn:cite:hmt")
     } catch {
       case e: IllegalArgumentException =>
       case _ : Throwable => fail("Constructor should have thrown an IllegalArgumentException exception")
     }
    //  must  throwA[java.lang.IllegalArgumentException]
   //}
  }

/*
  "A CiteUrn" should {
   "throw an IllegalArgumentException if too many components" in {

     CiteUrn("urn:cite:hmt:msA.12r:sub") must  throwA[java.lang.IllegalArgumentException]
   }
  }

 "A CiteUrn" should {
  "throw an IllegalArgumentException if 'urn' component is missing" in {

    CiteUrn("XX:cite:hmt:msA.12r") must  throwA[java.lang.IllegalArgumentException]
    }
  }

  "A CiteUrn" should {
    "throw an IllegalArgumentException if required 'cite' component is missing" in {
     CiteUrn("urn:XX:hmt:msA.12r") must  throwA[java.lang.IllegalArgumentException]
    }
  }

  "A CiteUrn" should {
    "throw an IllegalArgumentException if object hierarchy exceeds 3 levels" in {
     CiteUrn("urn:cite:hmt:msA.12r.v1.subversion") must  throwA[java.lang.IllegalArgumentException]
   }
  }*/

}