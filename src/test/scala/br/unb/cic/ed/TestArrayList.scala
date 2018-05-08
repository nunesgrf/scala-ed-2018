package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.ArrayList
/*
  @brief Implementação dos testes na estrutura de dados ArrayList com a ferramenta de testes ScalaTest.

  @author nunesgrf
  @author brenfeliped
 */
class TestArrayList extends FlatSpec  with Matchers {
  var array = new ArrayList[Int](3)
  behavior of "A ArrayList"
  it should "have size == 0 before inserting any element" in{
    array.size() should be (0)
  }
  it should "have size == 3 after inserting 3 elements" in{
    array.insert(0,10)
    array.insert(1,9)
    array.insert(2, 8)
  }
  it should "have element == 10 in position 0" in{
    array.elementAt(0) should be (Some(10))
  }
  it should "have element == 8 in position 2" in{
    array.elementAt(2) should be (Some(8))
  }
  it should "have element == 9 in position 1" in{
    array.elementAt(1) should be (Some(9))
  }
  it should "have element == 8 in position 1 after remove element == 9" in{
    array.remove(1)
    array.elementAt(1) should be (Some(8))
  }
  it should "have size == 2 after remove one element of arrayList" in{
    array.size() should be (2)
  }
}
