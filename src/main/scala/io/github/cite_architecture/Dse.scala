package io.github.cite_architecture


package cite {

  class DseNode() {
    val textNode: CtsUrn
    val surface: CiteUrn
    val visual: CiteUrn
  }

  class DseEdition() {
    val edition: Vector[DseNode]
  }
  
}
