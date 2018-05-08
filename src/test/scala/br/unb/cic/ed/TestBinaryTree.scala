package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.BinaryTreeImpl
/*
  @brief Implementação dos testes na estrutura de dados BinaryTree com a ferramenta de testes ScalaTest.

  @author nunesgrf
  @author brenfeliped
 */
class TestBinaryTree extends FlatSpec with Matchers {
  var bTree = new BinaryTreeImpl[Int]
  behavior of "A BinaryTree"
  it should "have node quatity == 0 before addition any node" in{
    bTree.nodeQuanti() should be (0)
  }
  it should "After addition node 5 have exists node 5 in bTree" in{
    bTree.insert(5)
    bTree.exist(5) should be (true)
  }
  it should "bTree have  to be Balanced" in {
    bTree.insert(10)
    bTree.insert(4)
    bTree.insert(15)
    bTree.insert(3)
    bTree.startBalance() should be (true)
  }
  it should  "have node quatity == 4 after remove node 20" in{
    bTree.remove(3)
    bTree.nodeQuanti() should be (4)
  }
  it should "After be removed node == 20 exist have to be equal false" in{
    bTree.exist(20) should be (false)
  }
  it should "have to be true that node 4 exists" in{
    bTree.exist(4) should be (true)
  }
}
