package br.unb.cic.ed.traits

trait  Container[T] {
  def getIterator(index: Int = 0): Iterator[T]
}
