package edu.holycross.shot

package cite {

  /** A URN for a canonically text or passage of text.
  *
  * @constructor create a new CtsUrn
  * @param urnString String representation of CtsUrn validating
  * againt the CtsUrn specification
  */
  case class CtsUrn  (val urnString: String) extends Urn {
    /** Array of top-level, colon-delimited components.
    *
    * The Array will have 4 elements if the optional passage
    * component is omitted;  if will have 5 elements if the passage
    * component is included.
    */
    val components = urnString.split(":")

    // Verify syntax of submitted String:
    require(components(0) == "urn", "Invalid URN syntax: " + urnString + ". First component must be 'urn'.")
    require(components(1) == "cts", "Invalid URN syntax: " + urnString + ". Second component must be 'cts'.")
    require(componentSyntaxOk, "Invalid URN syntax: " + urnString + ". Wrong number of components.")
    require((workParts.size < 5), "Invalid URN syntax. Too many parts in work component " + workComponent )

    /** Required namespace component of the URN.*/
    def namespace = components(2)
    /** Required work component of the URN.*/
    def workComponent = components(3)
    /** Array of dot-separate parts of the workComponent.*/
    def workParts = workComponent.split("""\.""")
    /** Textgroup part of work hierarchy.
    */
    def textGroup = workParts(0)





    /** Work part of work hierarchy.
    *
    * Value is an empty string if there is no work part.
    */
    def workOption: Option[String] = {
      workParts.size match {
        case w if 2 until 5 contains w => Some(workParts(1))
        case _ => None
      }
    }

    def work = {
      try {
        workOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CtsUrnException("No work defined in " + urnString)
      }
    }


    /** Version part of work hierarchy.
    *
    * Value is an empty string if there is no version part.
    */
    def versionOption: Option[String] = {
      workParts.size match {
        case v if 3 until 5 contains v => Some(workParts(2))
        case _ => None
      }
    }
    def version: String = {
      try {
        versionOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CtsUrnException("No version defined in " + urnString)
      }
    }

    /** Exemplar part of work hierarchy.
    *
    * Value is an empty string if there is no exemplar part.
    */
    def exemplarOption: Option[String] = {
      workParts.size match {
        case 4 => Some(workParts(3))
        case _ => None
      }
    }

    def exemplar: String = {
      try {
        exemplarOption.get
      } catch {
        case e: java.util.NoSuchElementException => throw CtsUrnException("No exemplar defined in " + urnString)
      }
    }

    /** Enumerated WorkLevel for this workComponent.*/
    def workLevel = {
      workParts.size match {
        case 1 => WorkLevel.TextGroup
        case 2 => WorkLevel.Work
        case 3 => WorkLevel.Version
        case 4 => WorkLevel.Exemplar
      }
    }

    /** Optional passage component of the URN.
    *
    * Value is an empty string if there is no passage component.
    */
    def passageComponentOption: Option[String] = {
      components.size match {
        case 5 => Some(components(4))
        case _ => None
      }
    }
    def passageComponent = {
      passageComponentOption.get
    }

    /** Array of hyphen-separated parts of the passageComponent.
    *
    * The Array will contain 0 elements if passageComponent is empty,
    * 1 element if the passageComponent is a node reference, and
    * 2 elements if the passageComponent is a range reference.
    */
    def passageParts: Array[String] ={
      passageComponentOption match {
        case None => Array.empty[String]
        case s: Some[String] => s.get.split("-")
      }
    }

    /* * Depth of citation hierarchy. */
    // What is best value in case of range? Deepest?
    // Or shouldn't we better have depth on each node,
    // as we do with subreferencing?
    //def passageDepth = {}


    /** Single node of the passage component of the URN.
    *
    * Value is an empty string if there is no passage component
    * or if the passage component is a range reference.
    */
    val passageNode = if (passageParts.size == 1) passageParts(0) else ""

    val passageNodeParts = passageNode.split("@")
    val passageNodeRef = passageNodeParts(0)

    /** Full string value of the passage node's subref.*/
    val passageNodeSubref = subref(passageNode)
    /** Indexed text of the passage node's subref.*/
    val passageNodeSubrefText = subrefText(passageNode)
    /** Index value of the passage node's subref.*/
    val passageNodeSubrefIndex = subrefIndex(passageNode)



    /** First range part of the passage component of the URN.
    *
    * Value is an empty string if there is no passage component
    * or if the passage component is a node reference.
    */
    val rangeBegin = if (passageParts.size > 1) passageParts(0) else ""
    val rangeBeginParts = rangeBegin.split("@")
    val rangeBeginRef = rangeBeginParts(0)

    /** Full string value of the range beginning's subref.*/
    def rangeBeginSubref = {
      rangeBegin match {
        case "" => ""
        case default =>  default
      }
    }
    /** Indexed text of the range beginning's subref.*/
    val rangeBeginSubrefText = subrefText(rangeBegin)
    /** Index value of the range beginning's subref.*/
    val rangeBeginSubrefIndex = subrefIndex(rangeBegin)



    /** Second range part of the passage component of the URN.
    *
    * Value is an empty string if there is no passage component
    * or if the passage component is a node reference.
    */
    val rangeEnd = if (passageParts.size > 1) passageParts(1) else ""
    val rangeEndParts = rangeEnd.split("@")
    val rangeEndRef = rangeEndParts(0)
    /** Full string value of the range ending's subref.*/
    val rangeEndSubref = subref(rangeEnd)
    /** Indexed text of the range ending's subref.*/
    val rangeEndSubrefText = subrefText(rangeEnd)
    /** Index value of the range ending's subref.*/
    val rangeEndSubrefIndex = subrefIndex(rangeEnd)

    require(passageSyntaxOk, "Invalid URN syntax.  Error in passage component " + passageComponent)

    /** True if the URN refers to a range.*/
    def isRange = {
      passageComponent contains "-"
    }

    /** True if URN's syntax for required components is valid.*/
    def componentSyntaxOk = {
      components.size match {
        case 5 => true
        case 4 => if (urnString.takeRight(1) == ":") true else false
        case _ => false
      }
    }

    /** True if URN's syntax for optional passage component is valid.*/
    def passageSyntaxOk = {
      passageParts.size match {
        case 0 => {
          passageComponentOption match {
            case None => true
            case _ => false
          }
        }
        case 1 => if (passageComponent.contains("-")) false else true
        case 2 => ((rangeBegin.size > 0) && (rangeEnd.size > 0))
      }
    }



    def dropPassage = {
      CtsUrn("urn:cts:" + namespace + ":" + workComponent + ":")
    }

    def dropSubref = {
      val baseString = dropPassage
      if (isRange) {
        CtsUrn(baseString + rangeBeginRef + "-" + rangeEndRef)
      } else {
        CtsUrn(baseString + passageNodeRef)
      }
    }

    /** true if work reference in `urn` is contained
    * in or equal to the work reference of this CtsUrn.
    *
    * @param urn CtsUrn to compare to this one.
    */
    def workContainedIn(urn: CtsUrn): Boolean = {
      val psg = urn.workComponent
      val str = "(^" + psg + """\.)|(^""" + psg + "$)"
      val pttrn = str.r

      val res = pttrn.findFirstIn(workComponent.toString)
      //println("Result of matching  " + str + " in " + urn.toString + " == " + res)
      res match {
        case None => false
        case _ => true
      }
    }
    /** true if passage reference in `urn` is contained
    * in or equal to the passage reference of this CtsUrn.
    *
    * @param urn CtsUrn to compare to this one.
    */
    def passageContainedIn(urn: CtsUrn): Boolean = {
      val psg = urn.dropSubref.passageComponent
      val str = "(^" + psg + """\.)|(^""" + psg + "$)"
      val pttrn = str.r

      val res = pttrn.findFirstIn(dropSubref.passageComponent.toString)
      //("Result of matching  " + str + " in " + urn.toString + " == " + res)
      res match {
        case None => false
        case _ => true
      }
    }

    /** true if the passage reference of either `urn`
    * of this CtsUrn is contained by the other.
    *
    * @param urn CtsUrn to compare to this one
    */
    def passageMatch(urn: CtsUrn): Boolean = {
      passageContainedIn(urn) || urn.passageContainedIn(this)
    }
    /** true if the passage reference of either `urn`
    * of this CtsUrn is contained by the other.
    *
    * @param urn CtsUrn to compare to this one
    */
    def workMatch(urn: CtsUrn): Boolean = {
      workContainedIn(urn) || urn.workContainedIn(this)
    }
    def urnMatch(urn: CtsUrn): Boolean = {
      namespace == urn.namespace && workMatch(urn) && passageMatch(urn)
    }

    override def toString() = {
      urnString
    }
  }


  /** Enumeration of levels of the CTS work hierarchy. */
  object WorkLevel extends Enumeration {
    val TextGroup, Work, Version, Exemplar = Value
  }



}
