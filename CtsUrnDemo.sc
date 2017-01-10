
// You need to have a resolver for UH to do this:
import edu.holycross.shot.cite._

def demoNode(u: CtsUrn) {
  println("\n\tSingle node cited")

  u.passageNodeSubrefOption match {
    case None => println("\tNo subreference")
    case subref: Some[String] => {
      println("\tFull subref is " + subref.get)
    }
  }

  u.passageNodeSubrefTextOption match {
    case None => println("\tNo subreference text")
    case subref : Some[String]=> println("\tCited text of subref is " + subref.get)
  }
  u.passageNodeSubrefIndexOption match {
    case None => println("\tNo subreference index")
    case i: Some[Int] => println("\tIndex of subref is " + i.get)
  }
}

def demoRange(u: CtsUrn) {
  println("\n\tRange cited")
  println("\tFirst node is " + u.rangeBegin)

  u.rangeBeginSubrefOption match {
    case None => println("\tNo subreference")
    case subref: Some[String] => {
      println("\tFull subref is " + subref.get)
    }
  }
  u.rangeBeginSubrefTextOption match {
    case None => println("\tNo subreference text")
    case subref: Some[String] => println("\tCited text of subref is " + subref.get)
  }
  u.rangeBeginSubrefIndexOption match {
    case None => println("\tNo subreference index")
    case i: Some[Int] => println("\tIndex of subref is " + i.get)
  }




  println("\n\tSecond node is " + u.rangeEnd)

  u.rangeEndSubrefOption match {
    case None => println("\tNo subreference")
    case subref : Some[String]=> {
      println("\tFull subref is " + subref.get)
    }
  }

  u.rangeEndSubrefTextOption match {
    case None => println("\tNo subreference text")
    case subref: Some[String] => println("\tCited text of subref is " + subref.get)
  }
  u.rangeEndSubrefIndexOption match {
    case None => println("\tNo subreference index")
    case i: Some[Int] => println("\tIndex of subref is " + i.get)
  }

}

def showOff(s: String) {
  val u = CtsUrn(s)

  println("For CTS URN " + u)

  // These are required:
  println("\tNamespace is " + u.namespace)
  println("\tText group is " + u.textGroup)
  println("\tCitation level of work hierarchy is " + u.workLevel)
  // These are optional:
  u.workOption match {
    case None => println("\tno work part")
    case work: Some[String] => println("\tWork is " + work.get)
  }
  u.versionOption match {
    case None => println("\tno version")
    case vers: Some[String] => println("\tVersion is " + vers.get)
  }
  u.exemplarOption match {
    case None => println("\tno exemplar")
    case exemplar: Some[String] => println("\tExemplar is " + exemplar.get)
  }
  u.passageComponentOption match {
    case None => println("\tno passage")
    case psg: Some[String] => println("\tPassage is " + psg.get)
  }

  u.isRange match {
    case true => demoRange(u)
    case false => demoNode(u)
  }

}
