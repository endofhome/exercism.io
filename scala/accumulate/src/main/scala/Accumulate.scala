import scala.collection.mutable.ListBuffer

class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] = {
    val processedElements = new ListBuffer[B]
    list.foreach(processedElements += f(_))
    processedElements.toList
  }
}
