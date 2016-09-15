package io.github.cite_architecture

package cite {





  /** A URN for a canonically text or passage of text.
  *
  * @constructor create a new CtsUrn
  * @param urnString String representation of CtsUrn validating
  * againt the CtsUrn specification
  */
  case class CiteUrn  (val urnString: String) extends Urn {
    /** Array of four top-level, colon-delimited components.
    */
    val components = urnString.split(":")

    require(components.size == 4, "Wrong number of components in  " + urnString + " - " + components.size)

    // Verify syntax of submitted String:
    require(components(0) == "urn", "Invalid URN syntax: " + urnString + ". First component must be 'urn'.")
    require(components(1) == "cite", "Invalid URN syntax: " + urnString + ". Second component must be 'cts'.")

    /** Required namespace component of the URN.*/
    def namespace = components(2)

    /** Required work component of the URN.*/
    def objectComponent = components(3)

    /** Array of dot-separated parts of the objectComponent.*/
    def objectParts = objectComponent.split("\\.")
    require((objectParts.size < 4) && (objectParts.size > 0), "Invalid number of parts in object component " + objectComponent + " - " + objectParts.size)

    def collection = objectParts(0)


    /** Object part of work hierarchy.
    *
    * Value is an empty string if there is no work part.
    */
    def obj = {
      objectParts.size match {
        case 2 => objectParts(1)
        case 3 => objectParts(1)
        case _ => ""
      }
    }

    /** Version part of work hierarchy.
    *
    * Value is an empty string if there is no version part.
    */
    def version = {
      objectParts.size match {
        case 3 => objectParts(2)
        case _ => ""
      }
    }



    // Still need to add subreff on single nodes
    // Still need to add range URNs
    // Still need to add subreff on range nodes



    override def toString() = {
      urnString
    }
  }



}
