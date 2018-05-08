package br.unb.cic.ed.mutable

class ArrayList[T: Manifest](private val max: Int = 10) extends br.unb.cic.ed.traits.List[T]{

  private var _size = 0
  private val elements = new Array[T](max)
  private val container = new br.unb.cic.ed.mutable.ArrayContainer[T](elements)

  private def isValid(pos: Int): Boolean = pos >= 0 && pos <= _size && pos < max

  def insert(pos: Int, value: T): Unit = {
    if(isValid(pos)) {
      if(pos == _size) elements(pos) = value
      else {
        for(i <- (_size - 1) to pos by -1) {
          elements(i+1) = elements(i)
        }
        elements(pos) = value
      }
      _size += 1
    }
    else throw InvalidArgument("insert pos must be between 0 and element.length")
  }

  def remove(pos: Int): Unit = {

    val iter = container.getIterator(pos)
    var i = pos

    println("Index do iterator = " + iter.indexnumber)
    if(isValid(pos)) {
      iter.next

      while(iter.hasNext) {
        iter.next match {
          case Some(a) => elements(i) = a
          case None => InvalidArgument("Something is messed up with this list")
        }
        i += 1
      }
      _size -= 1
    }
    else InvalidArgument("insert pos must be betwen 0 and element.length")
  }

  def elementAt(pos: Int): Option[T] = {
    if(isValid(pos)) return Some(elements(pos))
    None
  }

  def find(value: T): Option[Int] = {

    val iter = container.getIterator()

    while(iter.hasNext) {
      if(iter.next.contains(value)) return Some(iter.indexnumber-1)
    }
    None
  }

  def size(): Int = _size
}
