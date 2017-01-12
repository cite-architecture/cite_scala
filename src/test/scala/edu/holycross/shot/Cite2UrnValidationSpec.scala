
package edu.holycross.shot.cite


import org.scalatest.FlatSpec

class Cite2UrnValidationSpec extends FlatSpec {

  "A Cite2Urn constructor" should "construct a URN object from a well-formed string with object identifer" in {
    val urn = Cite2Urn("urn:cite:hmt:msA.release1:12r")
    urn match {
      case u: Cite2Urn => assert(true)
      case _ => fail("Failed to construct Cite2Urn")
    }
  }
  it should "construct a URN object from a well-formed string with no object identifer" in {
    val urn = Cite2Urn("urn:cite:hmt:msA.release1:")
    urn match {
      case u: Cite2Urn => assert(true)
      case _ => fail("Failed to construct Cite2Urn")
    }
  }
  it should "throw an IllegalArgumentException if there are too few components" in {
     try {
      Cite2Urn("urn:cite:hmt:")
     } catch {
       case e: IllegalArgumentException => assert(e.getMessage() == "requirement failed: wrong number of components in  urn:cite:hmt: - 3")
       case ex : Throwable => fail("Constructor should have thrown an IllegalArgumentException exception " + ex)
     }
  }
  it should   "throw an IllegalArgumentException if too many components" in  {
    try {
      Cite2Urn("urn:cite:hmt:msA.12r:subobject")
    } catch {
      case e: IllegalArgumentException => assert(true)
      case ex: Throwable => fail ("Unrecognized error: " + ex)
   }
  }
 it should  "throw an IllegalArgumentException if 'urn' component is missing" in {
   try {
    Cite2Urn("XX:cite:hmt:msA:12r")
  } catch {
    case e: IllegalArgumentException => assert(true)
    case ex: Throwable => fail("Unrecognized exception " + ex)
    }
  }
  it should "throw an IllegalArgumentException if required 'cite' component is missing" in  {
     try {
       Cite2Urn("urn:XX:hmt:msA:12r")
     } catch {
       case e: java.lang.IllegalArgumentException => assert(true)
       case ex: Throwable => fail("Unrecognized exception: " + ex)
    }
  }
  it should "throw an IllegalArgumentException if the required collection hierarchy exceeds 2 levels" in {
    try {
     Cite2Urn("urn:cite:hmt:msA.12r.v1.subversion:")
   } catch {
     case e: java.lang.IllegalArgumentException => assert(true)
     case ex: Throwable => fail("Unrecognized exception: " + ex)
   }
  }

  it should "have a non-empty namespace" in {
    val urn = Cite2Urn("urn:cite:hmt:msA.release1:")
    assert (urn.namespace == "hmt")
  }
  it should "have a non-empty hierarchical collection identifier" in {
    val urn = Cite2Urn("urn:cite:hmt:msA.release1:")
    assert (urn.collection == "msA")
  }
  it should "allow a none option for object component" in {
    val urn = Cite2Urn("urn:cite:hmt:msA.release1:")
    urn.objectComponentOption match {
      case None => assert(true)
      case _ => fail("Should have created none option")
    }
  }
  it should "retrieve"

}