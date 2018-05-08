package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.Hashmap
/*
  @brief Implementação dos testes na estrutura de dados Hashmap com a ferramenta de testes ScalaTest.

  @author nunesgrf
  @author brenfeliped
 */
class TestHashmap extends FlatSpec with Matchers {
  var hashmap = new Hashmap[String]
  behavior of "A hashmap"
  it should "hashmap have to find ED with index == 0" in{
    hashmap.insertIndex("BR")
    hashmap.insertIndex("UNB")
    hashmap.insertIndex("CIC")
    hashmap.insertIndex("ED")
    hashmap.findIndex("ED") should be (Some(0))
  }
  it should "hashmap have to find 0 in findlist(CIC,TP1)" in{
    hashmap.insertList("BR","Distrito Federal")
    hashmap.insertList("UNB", "Departamento de Ciencia da computaçao")
    hashmap.insertList("CIC", "TP1")
    hashmap.insertList("ED", "Hashmap")
    hashmap.findList("CIC","TP1") should be (Some(0))
  }
  it should "hashmap have to find 1 in findlist(CIC,TP2)" in{
    hashmap.insertList("CIC", "TP2")
    hashmap.findList("CIC","TP1") should be (Some(1))
  }
  it should "hashmap have to find 0 in findlist(CIC,TP1) after TP2 list be removed)" in{
    hashmap.removeList("CIC", "TP2")
    hashmap.findList("CIC","TP1") should be (Some(0))
  }
  it should "After remove index ED, CIC have to be Index == 0" in{
    hashmap.removeIndex("ED")
    hashmap.findIndex("CIC") should be (Some(0))
  }
}
