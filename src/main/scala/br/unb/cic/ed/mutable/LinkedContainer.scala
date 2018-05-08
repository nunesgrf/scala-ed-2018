package br.unb.cic.ed.mutable
import br.unb.cic.ed.traits._

/*
  @brief Container que retorna Linkediterators para as implementações lineares baeados em nós.

  @author nunesgrf
  @author brenfeliped

 */
class LinkedContainer[T: Manifest](private val node: No[T]) extends LinkContainer[T] {

  override def getIterator(index: Int = 0): LinkIterator[T] = new LinkedIterator[T](node, index)

  private class LinkedIterator[T](private var node: No[T], index: Int) extends LinkIterator[T] {
    gotoIndex // Esse método executado toda toda vez que é criada uma instância da classe.
    private var _index = 0
    // Itera até o Index fornecido pela função-mãe.
    private def gotoIndex: Unit = {
      var i = 0
      while (this.hasNext && i <= index) {
        node = node.getProximo()
        i += 1
      }
      _index = i
    }

    def indexnumber: Int = _index

    def hasNext: Boolean = node.getProximo() != null

    override def next: Option[No[T]] = {

      var i = 0
      val aux = node

      if(this.hasNext) {
        node = node.getProximo()
        i += 1
      }
      Some(aux)
    }
  }
}