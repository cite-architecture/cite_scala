package edu.holycross.shot

package cite {


  /** A URN for a citable object in a collection.
  *
  * @constructor create a new Cite2Urn
  * @param urnString String representation of Cite2Urn validating
  * against the Cite2Urn specification
  */
  case class Cite2Urn (val urnString: String) extends Urn {


    /** Array of four top-level, colon-delimited components.
    */
    val components = urnString.split(":")

    require(((components.size == 4) || (components.size == 5)), "wrong number of components in  " + urnString + " - " + components.size)

    // Verify syntax of submitted String:
    require(components(0) == "urn", "invalid URN syntax: " + urnString + ". First component must be 'urn'.")
    require(components(1) == "cite2", "invalid URN syntax: " + urnString + ". Second component must be 'cite'.")

    /** Required namespace component of the URN.*/
    val namespace = components(2)


    /////////// Collection component
    /** Required work component of the URN.*/
    val collectionComponent = components(3)
    val collectionParts = collectionComponent.split("""\.""").toVector
    val collection = collectionParts(0)


    def versionOption: Option[String] = {
      collectionParts.size match {
        case 2 => Some(collectionParts(1))
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


    // final requirements for collection syntax
    require(((collectionParts.size == 1) || (collectionParts.size == 2)), "invalid syntax in collection component of " + urnString)

    for (p <- collectionParts) {
      require(p.nonEmpty, "invalid value: empty value in collection component in " + urnString)
    }
    /////////// Object component
    //


    def objectComponentOption: Option[String] = {
      components.size match {
        case 5 => Some(components(4))
        case _ => None
      }
    }
    def objectComponent = {
      try {
        objectComponentOption.get
      } catch {
        case e: NoSuchElementException => throw CiteException("No object component defined in " + urnString)
        case otherE: Throwable => "ERROR: " + otherE
      }
    }

    val objectParts: Vector[String] = {
      objectComponentOption match {
        case None => Vector.empty[String]
        case s: Some[String] => {
          val parts = s.get.split("-")
          parts.size match {
            case 2 => parts.toVector
            case 1 => parts.toVector
            case _ => throw CiteException("Invalid object component syntax: " + urnString)
          }
        }
      }
    }
    val isRange = {
      (objectParts.size == 2)
    }
    val isObject = { objectParts.size == 1}




    // ranges
    val rangeBeginOption : Option[String] = {
      objectParts.size match {
        case 2 => Some(objectParts(0))
        case _ => None
      }
    }

    def rangeBegin: String = {
      try {
        rangeBeginOption.get
      } catch {
        case e: NoSuchElementException => throw CiteException("No range beginning defined in " + urnString)
        case ex: Throwable => throw(ex)
      }
    }



    val rangeEndOption : Option[String] = {
      objectParts.size match {
        case 2 => Some(objectParts(1))
        case _ => None
      }
    }
    def rangeEnd = {
      try {
        rangeEndOption.get
      } catch {
        case e: NoSuchElementException => throw CiteException("No range ending defined in " + urnString)
        case ex: Throwable => throw(ex)
      }
    }

    // final requirements for object syntax

    require(((objectParts.size >= 0) && (objectParts.size <= 2)), "invalid syntax in object component of " + urnString)
    if (isObject) {
      require ((urnString.contains("-") == false),"invalid range syntax in object component of " + urnString)
    } else {
      if (isRange) {
        require (urnString.contains("-"), "invalid range syntax in object component of " + urnString)
      } else {}
    }
    for (p <- objectParts) {
      require(p.nonEmpty, "invalid value: empty value in object component in " + urnString)
    }

    // extended references
    def singleObjectParts: Vector[String] = {
      if (objectParts.isEmpty) {
        Vector.empty[String]
      } else {
        val objParts = objectParts(0).split("@")
        if (objParts.size > 2) {
          throw CiteException("Invalid extended reference in " + urnString)
        } else {
          objParts.toVector
        }
      }
    }
    def rangeBeginParts: Vector[String] = {
      if (objectParts.isEmpty) {
        Vector.empty[String]
      } else {
        if (isRange) {
          val rbegin = rangeBegin.split("@").toVector
          if (rbegin.size > 2) {
            throw CiteException("Invalid extended reference on range beginning part of " + urnString)
          } else {
            rbegin
          }

        } else {
          Vector.empty[String]
        }
      }
    }
    def rangeEndParts: Vector[String] = {
      if (objectParts.isEmpty) {
        Vector.empty[String]
      } else {
        if (isRange) {
          val rend = rangeEnd.split("@").toVector
          if (rend.size > 2) {
            throw CiteException("Invalid extended reference on range ending part of " + urnString)
          } else {
            rend
          }

        } else {
          Vector.empty[String]
        }
      }
    }

    def objectExtensionOption : Option[String] = {
      singleObjectParts.size match {
        case 0 => None
        case 1 => None
        case 2 => Some(singleObjectParts(1))
      }
    }
    def objectExtension = {
      objectExtensionOption match {
        case None => throw CiteException("No extended reference in " + urnString)
        case s: Some[String] => s.get
      }
    }



    def rangeBeginExtensionOption : Option[String] = {
      rangeBeginParts.size match {
        case 0 => None
        case 1 => None
        case 2 => Some(rangeBeginParts(1))
      }
    }
    def rangeBeginExtension = {
      objectExtensionOption match {
        case None => throw CiteException("No extended reference in range beginning of " + urnString)
        case s: Some[String] => s.get
      }
    }

    def rangeEndExtensionOption : Option[String] = {
      rangeEndParts.size match {
        case 0 => None
        case 1 => None
        case 2 => Some(rangeEndParts(1))
      }
    }
    def rangeEndExtension = {
      objectExtensionOption match {
        case None => throw CiteException("No extended reference in range ending of " + urnString)
        case s: Some[String] => s.get
      }
    }

    override def toString() = {
      urnString
    }
    val labels = Vector(
      "URN",
      "Collection component",
      "Collection parts",
      "Collection",
      "Version option",
      "Object component option",
      "Object parts",
      "Is range",
      "Is object",
      "Single object parts",
      "Object extension option",
      "Range begin parts",
      "Range end parts",
      "Range begin extension option",
      "Range end extension option"

    )
    def debugString = {
      val valueList = Vector(
        urnString,
        collectionComponent,
        collectionParts,
        collection,
        versionOption.getOrElse(""),
        objectComponentOption.getOrElse(""),
        objectParts,
        isRange,
        isObject,
        singleObjectParts,
        objectExtensionOption.getOrElse(""),
        rangeBeginParts,
        rangeEndParts,
        rangeBeginExtensionOption.getOrElse(""),
        rangeEndExtensionOption.getOrElse("")



      )
      labels.zip(valueList).map {case (lbl,display) => lbl + ": " + display }
    }
  }



}
