package br.unb.cic.ed.mutable

class BinaryTreeImpl[T <% Comparable[T]] extends br.unb.cic.ed.traits.BinaryTree[T] {

  var _numberOfNodes: Int = 0
  var root: BtNode[T] = null

  def insert(v: T): Unit = {
    if (root == null) root = new BtNode[T](v)
    else root.insert(v)
    _numberOfNodes += 1
  }

  def remove(v: T): Option[T] = {
    if(!exist(v) || root == null) None
    else {
      //while(exist(v)) Some(root.remove(v)) LOOP INFINITO
      Some(root.remove(v))
      _numberOfNodes -= 1
      None
    }
  }

  def exist(v: T): Boolean =
    if(root == null) false
    else root.search(v)

  def startBalance(): Boolean = root.isBalanced(_numberOfNodes)

  def nodeQuanti(): Int = _numberOfNodes
}