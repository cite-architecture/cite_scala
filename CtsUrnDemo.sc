
// You need to have a resolver for UH to do this:
import edu.holycross.shot.cite._

def demoNode(u: CtsUrn) {
  println("\n\tSingle node cited")
  u.passageNodeSubref match {
    case "" => println("\tNo subreference")
    case subref => {
      println("\tFull subref is " + subref)
    }
  }
  if (u.passageNodeSubref != "") {
    u.passageNodeSubrefText match {
      case "" => println("\tNo subreference text")
      case subref => println("\tCited text of subref is " + subref)
    }
    u.passageNodeSubrefIndex match {
      case "" => println("\tNo subreference index")
      case i => println("\tIndex of subref is " + i)
    }
  }
}

def demoRange(u: CtsUrn) {

  println("\n\tRange cited")
  println("\tFirst node is " + u.rangeBegin)

  u.rangeBeginSubref match {
    case "" => println("\tNo subreference")
    case subref => {
      println("\tFull subref is " + subref)
    }
  }
  if (u.rangeBeginSubref != "") {
    u.rangeBeginSubrefText match {
      case "" => println("\tNo subreference text")
      case subref => println("\tCited text of subref is " + subref)
    }
    u.rangeBeginSubrefIndex match {
      case "" => println("\tNo subreference index")
      case i => println("\tIndex of subref is " + i)
    }
  }



  println("\n\tSecond node is " + u.rangeEnd)

  u.rangeEndSubref match {
    case "" => println("\tNo subreference")
    case subref => {
      println("\tFull subref is " + subref)
    }
  }
  if (u.rangeEndSubref != "") {
    u.rangeEndSubrefText match {
      case "" => println("\tNo subreference text")
      case subref => println("\tCited text of subref is " + subref)
    }
    u.rangeEndSubrefIndex match {
      case "" => println("\tNo subreference index")
      case i => println("\tIndex of subref is " + i)
    }
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
  u.work match {
    case "" => println("\tno work part")
    case default => println("\tWork is " + default)
  }
  u.version match {
    case "" => println("\tno version")
    case default => println("\tVersion is " + default)
  }
  u.exemplar match {
    case "" => println("\tno exemplar")
    case default => println("\tExemplar is " + default)
  }
  u.passageComponent match {
    case "" => println("\tno passage")
    case default => println("\tPassage is " + default)
  }
  if (u.passageComponent != "") {
    u.isRange match {
      case true => demoRange(u)
      case false => demoNode(u)
    }
  }
}
