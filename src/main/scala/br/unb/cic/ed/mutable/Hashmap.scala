package br.unb.cic.ed.mutable

/*
  @brief Implementação de um hashmap.

  @author nunesgrf
  @author brenfeliped
 */
class Hashmap[T: Manifest] extends br.unb.cic.ed.traits.Hashmap[T] {

  val index = new LinkedList[T]
  val matrix = new LinkedList[LinkedList[T]]

  def insertIndex(value: T): Unit = {

    val linkedlist = new LinkedList[T]

    index.insert(0,value)
    matrix.insert(0,linkedlist)
  }

  def removeIndex(value: T): Unit = {

    index.find(value) match {
      case Some(pos) => {
        index.remove(pos)
        matrix.remove(pos)
      }
      case None => throw InvalidArgument("Valor não existente no Hash")
    }
  }

  def findIndex(value: T): Option[Int] ={

    index.find(value) match {
      case Some(a) => Some(a)
      case None => throw InvalidArgument("O argumento não existe no Index")
    }
  }

  def insertList(targetnode: T, relnode: T): Unit = {

    var pos = 0
    var aux = new LinkedList[T]

    index.find(targetnode) match {
      case Some(a) => pos = a
      case None => throw InvalidArgument("Não existe esse indice para inserção.")
    }

    matrix.elementAt(pos) match {
      case Some(list) => aux = list
      case None => throw InvalidArgument("Não existe esse indice para remoção.")
    }

    aux.insert(0,relnode)
  }

  def removeList(targetnode: T, relnode: T): Unit = {

    var posToRemove = 0
    var aux = new LinkedList[T]

    index.find(targetnode) match {
      case Some(pos) => posToRemove = pos
      case None => throw InvalidArgument("O nó que se deseja remover uma relação não existe.")
    }

    matrix.elementAt(posToRemove) match {
      case Some(list) => aux = list
      case None => throw InvalidArgument("Não há o que remover")
    }

    aux.find(relnode) match {
      case Some(i) => aux.remove(i)
      case None => throw InvalidArgument("Não existe este elemento para remoção")
    }
  }

  def findList(targetnode: T,value: T): Option[Int] = {

    var aux = 0
    var aux_list = new LinkedList[T]

    index.find(targetnode) match {
      case Some(a) => aux = a
      case None => throw InvalidArgument("Não há esta instância de grafo")
    }

    matrix.elementAt(aux) match {
      case Some(list) => aux_list = list
      case None => throw InvalidArgument("Não há esta instância no grafo")
    }

    aux_list.find(value)
  }

  def elementsIndex(value: T): LinkedList[T] = {

    var pos = 0

    index.find(value) match {
      case Some(a) => pos = a
      case None => throw InvalidArgument("Não existe essa lista na tabela")
    }
    matrix.elementAt(pos) match {
      case Some(list) => list
      case None => throw InvalidArgument("Não existe essa lista na tabela")
    }
  }
}

