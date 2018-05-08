package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.LinkedList
/*
  @brief Implementação dos testes na estrutura de dados LinkedList com a ferramenta de testes ScalaTest.

  @author nunesgrf
  @author brenfeliped
 */
class TestLinkedList extends FlatSpec with Matchers {
  var linkedlist = new LinkedList[Int]
  behavior of "A LikedList"
  it should "have size == 0 before inserting  any element" in{
    linkedlist.size() should be (0)
  }
  it should "have size == 3 after be inserting 3 elements" in{
    linkedlist.insert(0,10)
    linkedlist.insert(1,20)
    linkedlist.insert(2, 30)
    linkedlist.size() should be (3)
  }
  it should "have to find the element == 30" in{
    linkedlist.find(30)  should be (Some(2))
  }
  it should "have element == 10 in position 0" in{
    linkedlist.elementAt(0) should be (Some(10))
  }
  it should  "have element == 20 in position 0 after remove element == 10" in{
    linkedlist.remove(0)
    linkedlist.elementAt(0) should be (Some(20))
  }

}
