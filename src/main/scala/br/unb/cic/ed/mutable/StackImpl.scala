package br.unb.cic.ed.mutable
import br.unb.cic.ed.traits._

/*
  @brief Implementação de uma pilha utilizando lista.

  @author nunesgrf
  @author brenfeliped
 */
class StackImpl[T: Manifest] (private val elements: List[T]) extends Stack[T] {

  def size(): Int = elements.size()
  def peek(): Option[T] = elements.elementAt(0)
  def push(value: T): Unit = elements.insert(0,value)
  def pop(): Option[T] = {
    val aux = elements.elementAt(0)
    elements.remove(0)
    aux
  }
}
