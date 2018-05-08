package br.unb.cic.ed.mutable
import br.unb.cic.ed.traits._
/*
  @brief Implementação de uma fila utilizando uma lista.

  @author nunesgrf
  @author brenfeliped
 */
class QueueImpl[T: Manifest](private val elements: List[T]) extends Queue[T] {

  def size(): Int = elements.size()
  def last(): Option[T] = elements.elementAt(0)
  def first(): Option[T] = elements.elementAt(elements.size()-1)
  def enqueue(value: T): Unit = elements.insert(0,value)
  def dequeue(): Option[T] = {
    val aux = elements.elementAt(elements.size()-1)
    elements.remove(elements.size()-1)
    aux
  }
}
