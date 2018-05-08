package br.unb.cic.ed.mutable
import br.unb.cic.ed.traits._

/*
  @brief Uma simples LinkedList com operações básicas sobre a mesma.

  @author nunesgrf
  @author brenfeliped
 */
class LinkedList[T:Manifest] extends List[T] {

  /*
    @brief Por decisão de projeto, esta lista ligada
    sempre é inicializada com dois nós: @param head
    e @param last.

    head e last não contém valores, somente marcam o inicio e
    fim da lista; inicialmente head -> last como se pode ver em (1).
   */
  private var head = new No[T]
  private var last = new No[T]
  head.setProximo(last) // (1)

  // @param container inicializa os iterators que irão iterar sobre a lista marcada pro @param head.
  private val container = new LinkedContainer[T](head)

  // @param _size marca o tamanho da lista.
  private var _size = 0


  /*
    @brief Simples função de inserção em uma
    lista ligada, realiza a seguinte operação
    com os iterator @param iter e @param iteraux:

    1. ... -> iter -> iteraux -> ...
    2.      ... -> iter -> iteraux -> ...
            node -> iteraux -> ...
    3. ... -> iter -> node -> ...
    4. ... -> iter -> node -> iteraux -> ...
   */
  def insert(pos: Int, value: T): Unit = {

    val iter = container.getIterator(pos)
    val iteraux = container.getIterator(pos-1)
    val node = new No[T]

    node.setDado(value)

    iter.next match {
      case Some(a) => node.setProximo(a)
      case None => throw InvalidArgument("A inserção falhou")
    }
    iteraux.next match {
      case Some(b) => b.setProximo(node)
      case None => throw InvalidArgument("A inserção falhou")
    }
    _size += 1
  }

  /*
    @brief retorna encapsulado o valor que estava dentro
    da posição @param pos da lista, caso exista.
   */
  def elementAt(pos: Int): Option[T] = {

    if(pos < _size) {
      val iter = container.getIterator(pos)
      val aux = iter.next

      aux match {
        case Some(a) => a.getDado()
        case None => throw InvalidArgument("A busca na posição deu errado")
      }
    }
    else None
  }
  /*
    @brief Função que baseado em um valor @param value
    itera sobra a lista até encontrar value na lista
    e retorna o valor encapsulado.

   */
  def find(value: T): Option[Int] = {

    val iter = container.getIterator()
    var i = 0

    while(iter.hasNext) {

      iter.next match {
        case Some(a) => if(a.getDado().contains(value)) return Some(i)
        case None => return None
      }
      i += 1
    }
    None
  }

  /*
  @brief Função de remoção de um elemento da lista
  baseado em uma posição @param pos da lista.

  @param iter e @param iteraux são iteradores que avançam
  até as posições pos-1 e pos+1 e realizam a seguinte
  operação:

  1. ... -> iter -> node -> iteraux -> ...
  2. ... -> iter -x node -> iteraux -> ...
  3. ... -> iter -> iteraux -> ...
 */
  def remove(pos: Int): Unit = {

    val iter = container.getIterator(pos-1)
    val iteraux = container.getIterator(pos+1)
    var b = new No[T]

    iteraux.next match {
      case Some(c) => b = c
      case None => throw InvalidArgument("A remoção falhou")
    }
    iter.next match {
      case Some(a) => a.setProximo(b)
      case None => throw InvalidArgument("A remoção falhou")
    }
  }
  /*
    @brief Simples função de retorno da variável _size
   */
  def size(): Int = _size
}
