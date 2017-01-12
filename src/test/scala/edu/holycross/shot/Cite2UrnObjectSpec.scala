
package edu.holycross.shot.cite


import org.scalatest.FlatSpec

class Cite2UrnObjectSpec extends FlatSpec {

  "A Cite2Urn" should "should have an empty option if no object is given" in pending
  it should "should retrieve a string value for a well-formed passage identifier" in pending
  it should "throw a CITE exception when trying to retrieve a non-existent passage component" in pending

  it should "thow a CiteException if the object range has more than two parts" in pending
  it should "identify a range reference as a range and not a node" in pending
    it should "identify a node reference as a node and not a range" in pending
  it should "throw an IllegalArgumentException if a range has an empty first node" in pending
  it should "throw an IllegalArgumentException if a range has an empty second node" in pending
  
}
