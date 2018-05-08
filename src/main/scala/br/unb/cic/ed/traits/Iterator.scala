package br.unb.cic.ed.traits

trait Iterator[T] {

  def indexnumber: Int
  def hasNext: Boolean
  def next: Option[T]
}
