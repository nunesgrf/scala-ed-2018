package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.StackImpl
import br.unb.cic.ed.mutable.LinkedList
/*
  @brief Implementação dos testes na estrutura de dados Stack com a ferramenta de testes ScalaTest.

  @author nunesgrf
  @author brenfeliped
 */
class TestStack extends FlatSpec with Matchers {
  var list = new LinkedList[Int]
  var stack = new StackImpl[Int](list)
  behavior of "A Stack"
  it should "have size == 0 before push any element" in{
    stack.size() should be (0)
  }
  it should "have size == 1 after push element 5" in{
    stack.push(5)
    stack.size() should be (1)
  }
  it should "have on top the stack element == 30 after push [10,20,30]"in {
    stack.push(10)
    stack.push(20)
    stack.push(30)
    stack.peek() should be (Some(30))
  }
  it should "have the element == 30 with pop and after on top the stack have element == 20" in{
    stack.pop() should be  (Some(30))
    stack.peek() should be (Some(20))
  }
}
