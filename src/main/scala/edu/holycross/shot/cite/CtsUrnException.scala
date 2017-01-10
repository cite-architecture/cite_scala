package edu.holycross.shot

package cite {

  case class CtsUrnException(message: String = "", cause: Option[Throwable] = None) extends Exception(message) {
    cause.foreach(initCause)
  }

}
