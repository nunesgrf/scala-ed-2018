package br.unb.cic.ed.traits

trait BinaryTree[T] {
  def insert(v: T): Unit
  def exist(v: T): Boolean
  def startBalance(): Boolean
  def nodeQuanti(): Int
  def remove(v: T): Option[T]
}
