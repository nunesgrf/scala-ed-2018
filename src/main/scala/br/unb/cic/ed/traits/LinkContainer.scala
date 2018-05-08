package br.unb.cic.ed.traits

trait LinkContainer[T] {
  def getIterator(index: Int = 0): LinkIterator[T]
}
