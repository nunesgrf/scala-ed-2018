package br.unb.cic.ed.mutable

import br.unb.cic.ed.traits

class ArrayContainer[T: Manifest](private val elements: Array[T]) extends br.unb.cic.ed.traits.Container[T] {

  override def getIterator(index: Int = 0): traits.Iterator[T] = new ArrayIterator[T](elements,index)

  private class ArrayIterator[T](private val elements: Array[T],index: Int) extends br.unb.cic.ed.traits.Iterator[T] {

    private var _index = index

    def indexnumber: Int = _index
    def hasNext: Boolean = _index < elements.length
    def next: Option[T] = {

      if(this.hasNext) {
        var aux = elements(_index)
        _index += 1
        return Some(aux)
      }
      None
    }
  }
}
