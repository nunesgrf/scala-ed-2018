package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.QueueImpl
import br.unb.cic.ed.mutable.LinkedList
/*
  @brief Implementação dos testes na estrutura de dados Queue com a ferramenta de testes ScalaTest.

  @author nunesgrf
  @author brenfeliped
 */
class TestQueue extends FlatSpec with Matchers {
  var list = new LinkedList[Int]
  var queue  = new QueueImpl[Int](list)
  behavior of "A Queue"
  it should "have size == 0 before enqueue any element" in{
    queue.size should be (0)
  }
  it should "have size == 3 after enqueue 3 elements" in{
    queue.enqueue(100)
    queue.enqueue(257)
    queue.enqueue(360)
    queue.size() should be (3)
  }
  it should "have in first element == 100" in{
    queue.first() should be (Some(100))
  }
  it should "have in last element == 360" in{
    queue.last() should be (Some(360))
  }
  it should "dequeue should be == 100" in{
    queue.dequeue() should be (Some(100))
  }
}
