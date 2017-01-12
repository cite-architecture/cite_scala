
package edu.holycross.shot.cite


import org.scalatest.FlatSpec

class Cite2UrnExtendedRefSpec extends FlatSpec {

  "A Cite2Urn" should " have a none value for all subref options when no subref is defined" in pending

it should "have a string value for a object subref when the subref is defined without index" in pending
it should "have a string value for an object subref when the subref includes an explicit index" in pending
it should "have a string value for a subref on the first node of a range without index" in pending
it should "have a string value for a subref on the first node of a range when a subref includes an explicit index" in pending

it should "throw a Cite exception when trying to retrieve a non-existent subref value on the first node of a range" in pending

it should "have a string value for a subref on the second node of a range without index" in pending
it should "have a string value for a subref on the second node of a range when a subref includes an explicit index" in pending
it should "throw a Cite exception when trying to retrieve a non-existent subref value on the second node of a range" in pending

it should "have string values for subrefs on both nodes of a range without index" in pending
it should "have a string value for subrefs on both nodes of a range when the subrefs include an explicit index" in pending
it should "should throw a Cite exception when trying to retrieve non-existent subref values on either node of a range" in pending
}
