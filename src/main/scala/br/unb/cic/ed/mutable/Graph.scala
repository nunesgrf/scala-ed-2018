package br.unb.cic.ed.mutable


class Graph[T: Manifest]()extends br.unb.cic.ed.traits.Graph[T] {

  val graph = new Hashmap[T]

  def insertNode(node: T): Unit = graph.insertIndex(node)

  def removeNode(node: T): Unit = graph.removeIndex(node)

  def rel(node1: T, node2: T): Unit = graph.insertList(node1,node2)

  def removeRelation(node1: T, node2: T): Unit = graph.removeList(node1,node2)

  def isConected(node1: T, node2: T): Boolean = {

    var list = new LinkedList[T]
    var i = 0

    graph.findList(node1,node2) match {
      case Some(a) => return true
      case None => list = graph.elementsIndex(node1)
    }
    while(!list.elementAt(i).contains(null) && list.elementAt(i).isDefined) {
      list.elementAt(i) match {
        case Some(node) => return isConected(node,node2)
        case None => throw InvalidArgument("Não era pra entrar aqui nunca!")
      }
      i += 1
    }
    false
  }
}
