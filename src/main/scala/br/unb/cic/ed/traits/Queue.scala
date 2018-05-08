package br.unb.cic.ed.traits

trait Queue[T] {
  def enqueue(value: T): Unit
  def dequeue(): Option[T]
  def last(): Option[T]
  def first(): Option[T]
  def size(): Int
}