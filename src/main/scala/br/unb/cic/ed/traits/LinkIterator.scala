package br.unb.cic.ed.traits
import br.unb.cic.ed.mutable.No

trait LinkIterator[T] {
  def indexnumber: Int
  def next: Option[No[T]]
  def hasNext: Boolean
}