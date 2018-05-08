package br.unb.cic.ed.traits

trait Graph[T] {

  def insertNode(node: T): Unit
  def removeNode(node: T): Unit
  def rel(node1: T, node2: T): Unit
  def removeRelation(node1: T, node2: T): Unit
  def isConected(node1: T, node2: T): Boolean
}
