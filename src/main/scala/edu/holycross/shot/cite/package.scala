package edu.holycross.shot

/** The cite library supports working with canonical identifers
* used in citing scholarly resources. */
package object cite {
    // or a type...
    //type Ocho2Text = Vector[Ohco2Node]
      // a Vector of Ocho2Nodes


  /** Extracts the subref from a passage node value.
  *
  * @param s A passage node value, a reference to
  * a single node or to the beginning or ending node
  * of a range reference.
  */
  def subref(s: String) = {
    val psgSplit = s.split("@")
    psgSplit.size match {
      case 2 => psgSplit(1)
      case _ => ""
    }
  }


  /** Extracts the cited text of a subref from a passage node value.
  *
  * @param s A passage node value, a reference to
  * a single node or to the beginning or ending node
  * of a range reference.
  */
  def subrefText(s: String) = {
    val psgSplit = s.split("@")
    psgSplit.size match {
      case 2 => {
        val txtRE = """([^\[]+).+""".r
        psgSplit(1) match {
         case txtRE(sr) => sr
         case default => default
        }
      }
      case _ => ""
    }
  }


  /** Extracts the explicitly given index of a subref
  * from a passage node value.
  *
  * The index value must be an integer.
  * @param s A passage node value, a reference to
  * a single node or to the beginning or ending node
  * of a range reference.
  */
  def subrefIndex(subref: String) = {
    // hairball RE to extract indexing string
    // from within square brackets.
    val idxRE = """[^\[]+\[([^\]]+)\]""".r
    subref match {
      case idxRE(i) => try {
        i.toInt
      } catch {
        case e: NumberFormatException => None
      }
      case _ => None
    }
  }



}