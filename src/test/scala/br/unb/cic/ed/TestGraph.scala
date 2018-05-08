package br.unb.cic.ed
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.unb.cic.ed.mutable.Graph

class TestGraph extends FlatSpec with Matchers {
  var grafo = new Graph[String]
  behavior of "A Graph"
  it should "Node UNB have to be conected with node CIC"  in{
    grafo.insertNode("UNB")
    grafo.insertNode("CIC")
    grafo.rel("UNB", "CIC")
    grafo.isConected("UNB", "CIC") should be (true)
  }
  it should "isConected(CIC, UNB) have to be false" in{
    grafo.isConected("CIC", "UNB") should be (false)
  }
  it should "isConected(CIC,TP1) have to be true" in{
    grafo.insertNode("TP1")
    grafo.rel("CIC","TP1")
    grafo.isConected("CIC","TP1") should be (true)
    grafo.removeRelation("CIC","TP1")
  }
  it should "isConected(UNB, CIC) have to be false after romove relation" in{
    grafo.isConected("CIC","TP1") should be (false)
  }
}
