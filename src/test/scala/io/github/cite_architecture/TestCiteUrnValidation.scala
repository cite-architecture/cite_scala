
package io.github.cite_architecture.cite

// Modelled on examples in this blog post:
//http://blog.scalac.io/2015/03/27/specs2-notes.html
//
// I've still got tons to learn about specs2.
//
import org.specs2.mutable.Specification

class TestCiteUrnValidation extends Specification {

  "A CiteUrn" should {
   "throw an IllegalArgumentException if too few components" in {

     CiteUrn("urn:cite:hmt") must  throwA[java.lang.IllegalArgumentException]
   }
  }

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
  }
}
