package edu.holycross.shot

package cite {


  /** A URN for a citable object in a collection.
  *
  * @constructor create a new CiteUrn
  * @param urnString String representation of CiteUrn validating
  * against the CiteUrn specification
  */
  case class Cite2Urn (val urnString: String) extends Urn {

    /** Array of four top-level, colon-delimited components.
    */
    val components = urnString.split(":")

    require(components.size == 4, "wrong number of components in  " + urnString + " - " + components.size)

    // Verify syntax of submitted String:
    require(components(0) == "urn", "invalid URN syntax: " + urnString + ". First component must be 'urn'.")
    require(components(1) == "cite", "invalid URN syntax: " + urnString + ". Second component must be 'cite'.")

    /** Required namespace component of the URN.*/
    val namespace = components(2)

    /** Required work component of the URN.*/
    val objectComponent = components(3)

    val dotParts = objectComponent.split("""\.""")
    val collection = dotParts(0)
    require((dotParts.size < 4) && (dotParts.size > 0), "invalid number of parts in object component " + objectComponent + " - " + dotParts.size)

    val objectString = dotParts.tail.mkString(".")
    val objectParts = objectString.split("-")



    /*
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

*/

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
    def objectSubrefOption: Option[String] = {
      try {
        subrefOption(passageNode)
      } catch {
        case e: java.util.NoSuchElementException => None
        case citeEx: CiteException => None
        case otherEx : Throwable => throw( otherEx)
      }
    }

    def objectSubref = {
      try {
        objectSubrefOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No individual node subref defined in " + urnString)
        case otherEx : Throwable => throw( otherEx)
      }
    }
    // Still need to add range URNs
    // Still need to add subreff on range nodes

    def rangeBeginOption: Option[String] = {
      if (passageParts.size > 1) Some(passageParts(0)) else None
    }
    def rangeBegin = {
      try {
        rangeBeginOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No range beginning defined in " + urnString)
        case otherEx : Throwable => throw( otherEx)
      }
    }
    def rangeBeginParts = {
      rangeBeginOption match {
        case None => Array.empty[String]
        case _ => rangeBegin.split("@")
      }
    }
    def rangeBeginRefOption: Option[String] = {
      if (rangeBeginParts.isEmpty) None else Some(rangeBeginParts(0))
    }
    def rangeBeginRef = {
      try {
        rangeBeginRefOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No range beginning reference defined in " + urnString)
        case otherEx : Throwable => throw( otherEx)
      }
    }

    /** Full string value of the range beginning's subref.*/
    def rangeBeginSubrefOption = {
      rangeBeginOption match {
        case None => None
        case _ =>  subrefOption(rangeBegin)
      }
    }
    def rangeBeginSubref = {
      try {
        rangeBeginSubrefOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No range beginning subreference defined in " + urnString)
        case otherEx : Throwable => throw( otherEx)
      }
    }



    /** Second range part of the passage component of the URN.
    *
    * Value is an empty string if there is no passage component
    * or if the passage component is a node reference.
    */
    def rangeEndOption: Option[String] = {
      if (passageParts.size > 1) Some(passageParts(1)) else None
    }
    def rangeEnd = {
      try {
        rangeEndOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No range ending defined in " + urnString + " from passage parts " + passageParts.toVector)
        case otherEx : Throwable => throw( otherEx)
      }
    }
    def rangeEndParts = {
      rangeEndOption match {
        case None => Array.empty[String]
        case _ => rangeEnd.split("@")
      }
    }
    def rangeEndRefOption: Option[String] = {
      if (rangeEndParts.isEmpty) None else Some(rangeEndParts(0))
    }
    def rangeEndRef = {
      try {
        rangeEndRefOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No range ending reference defined in " + urnString)
        case otherEx : Throwable => throw( otherEx)
      }
    }

    /** Full string value of the range Endning's subref.*/
    def rangeEndSubrefOption = {
      rangeEndOption match {
        case None => None
        case _ =>  subrefOption(rangeEnd)
      }
    }
    def rangeEndSubref = {
      try {
        rangeEndSubrefOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CiteException("No range ending subreference defined in " + urnString)
        case otherEx : Throwable => throw( otherEx)
      }
    }




    override def toString() = {
      urnString
    }
  }



}
