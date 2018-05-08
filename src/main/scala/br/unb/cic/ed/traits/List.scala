package br.unb.cic.ed.traits

trait List[T] {
  def insert(pos: Int, value: T): Unit
  def remove(pos: Int): Unit
  def elementAt(pos: Int): Option[T]
  def find(value: T): Option[Int]
  def size(): Int
}
