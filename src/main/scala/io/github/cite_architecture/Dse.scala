package io.github.cite_architecture


package cite {

  class DseNode() {
    /** A single citable node of text.*/
    val textNode: CtsUrn
    /** A text-bearing surface.*/
    val surface: CiteUrn
    /** Visual documentary evidence for the node.*/
    val visual: CiteUrn
  }

  class DseEdition() {
    /** An ordered collection of DseNodes.*/
    val edition: Vector[DseNode]
  }

}
