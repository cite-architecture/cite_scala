package edu.holycross.shot

package cite {





  /** A URN for a canonically text or passage of text.
  *
  * @constructor create a new CiteUrn
  * @param urnString String representation of CiteUrn validating
  * againt the CtsUrn specification
  */
  case class CiteUrn  (val urnString: String) extends Urn {
    /** Array of four top-level, colon-delimited components.
    */
    val components = urnString.split(":")

    require(components.size == 4, "wrong number of components in  " + urnString + " - " + components.size)

    // Verify syntax of submitted String:
    require(components(0) == "urn", "invalid URN syntax: " + urnString + ". First component must be 'urn'.")
    require(components(1) == "cite", "invalid URN syntax: " + urnString + ". Second component must be 'cite'.")

    /** Required namespace component of the URN.*/
    def namespace = components(2)

    /** Required work component of the URN.*/
    def objectComponent = components(3)

    /** Array of dot-separated parts of the objectComponent.*/
    def objectParts = objectComponent.split("""\.""")
    require((objectParts.size < 4) && (objectParts.size > 0), "invalid number of parts in object component " + objectComponent + " - " + objectParts.size)

    def collection = objectParts(0)


    /** Object part of work hierarchy.
    *
    * Value is an empty string if there is no work part.
    */
    def objOption: Option[String] = {
      objectParts.size match {
        case 2 => Some(objectParts(1))
        case 3 => Some(objectParts(1))
        case _ => None
      }
    }
    def obj = {
      try {
        objOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No object defined in " + urnString)
      }
    }

    /** Version part of work hierarchy.
    *
    * Value is an empty string if there is no version part.
    */
    def versionOption: Option[String] = {
      objectParts.size match {
        case 3 => Some(objectParts(2))
        case _ => None
      }
    }
    def version = {
      try {
        versionOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No version defined in " + urnString)
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
