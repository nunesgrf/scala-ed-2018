package br.unb.cic.ed.traits

trait Stack[T] {
  def push(value: T): Unit
  def pop(): Option[T]
  def peek(): Option[T]
  def size(): Int
}

