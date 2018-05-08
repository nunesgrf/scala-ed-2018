package br.unb.cic.ed.traits

import br.unb.cic.ed.mutable.LinkedList

trait Hashmap[T] {

  def insertIndex(value: T): Unit
  def removeIndex(value: T): Unit
  def findIndex(value: T): Option[Int]
  def insertList(targetnode: T, relnode: T): Unit
  def removeList(targetnode: T, relnode: T): Unit
  def findList(targetnode: T, value: T): Option[Int]
  def elementsIndex(value: T): LinkedList[T]
}
