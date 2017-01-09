package edu.holycross.shot


package cite {


  /** The superclass of Urn objects, implemented by CtsUrn and CiteUrn.
  */
  abstract class Urn {}

  /** Trait for any citable scholarly resource.
  *
  * Implementing classes must have a Urn value
  * identifying the object.  An example in the cite
  * library is the Orca class.
  */
  trait Citable {
    val urn: Urn
  }

  trait Orca extends Citable {
    /** Identifier for the Orca object.*/
    val urn: Urn

    /** Identifier for the passage of text analyzed.
    *
    * Rdf verbs orca/rdf/analyzes <-> analyzedBy
    */
    val passage: CtsUrn

    /** Identifier for the result of the analysis.
    *
    * Rdf verbs orca/rdf/hasAnalysis <-> analysisFor
    */
    val analysis: CiteUrn

    /** Text reading or deformation resulting from the analysis.
    *
    * Rdf verb -> orca/rdf/textDeformation
    */
    val deformation: String
  }
}
