package br.unb.cic.ed.mutable

/*
  @brief Classe Nó de uma arvore binária que aceita elementos do trait Comparable.

  @author nunesgrf
  @author brenfeliped
 */
class BtNode[T <% Comparable[T]](var value: T, var left: BtNode[T] = null,var right: BtNode[T] = null) {

  // Função que determina a altura de uma arvore encabeçada por @param node.
  private def height(node: BtNode[T]): Int = {
    if(node == null) return 0
    1 + Math.max(height(node.left),height(node.right))
  }

  // Função matemática de modulo.
  private def mod(x: Int): Int = if(x >= 0) x else -x

  // Função matemática para o calculo de um logaritmo base 2.
  private def log2(x: Double): Double = Math.log(x)/Math.log(2)

  // Algoritmo de inserção em uma arvore binária.
  def insert(v: T): Unit = {
    if((v.compareTo(this.value)) <= 0) {
      if(left == null) left = new BtNode[T](v)
      else left.insert(v)
    }
    else {
      if(right == null) right = new BtNode[T](v)
      else right.insert(v)
    }
  }

  // Algoritmo de busca em uma arvore binária.
  def search(v: T): Boolean = {
    if(value == v) return true

    if(v.compareTo(this.value) <= 0) {
      if(left == null) return false
      left.search(v)
    }
    else {
      if(right == null) return false
      right.search(v)
    }
  }

  // Algoritmo que verifica se esta instância de arvore está balanceada.
  def isBalanced(numberOfNodes: Int): Boolean = {

    val diffheight = mod(height(this.left) - height(this.right))
    val htree = Math.max(height(this.left),height(this.right)) + 1

    if(diffheight <= 1 && Math.ceil(log2(numberOfNodes + 1)) == htree) true
    else false
  }

  //Algoritmo de busca para o no que vai ser removido
  private def searchRemove(v: T): BtNode[T] = {
    if(value == v) return this

    if(v.compareTo(this.value) <= 0) {
      if(left == null) return null
      left.searchRemove(v)
    }
    else {
      if(right == null) return null
      right.searchRemove(v)
    }
  }
  // Algoritmo de remorçao em uma arvore binaria
  def remove(v: T): Unit = {
    var removed = this.searchRemove(v)
    if(left == null && right ==  null){
      removed.value = left.value
      removed.left = left.left
      removed.right = left.right
    }
    else{
      if(left == null || right == null ){
        if(left== null){
          removed.value =  right.value
          removed.right = null
        }
        else {
          removed.value = left.value
          left = null
        }
      }
      else{
        var aux = left
        while(aux.right != null) aux=aux.right
        removed.value=aux.value
        aux= null
      }
    }
  }

  // Algoritmo de banleamento da arvore binaria
  def balancing(): Unit = {
    println("Balacing procedure...")
    /* val factor : Int = height(this.right) - height(this.left)
     val factorLeft : Int= height(left.right) - height(left.left)
     val factorRight : Int= height(right.right) - height(right.left)
     if(factor > 0){
       if(factorLeft >= 0){ // Rotaçao LL
         var temp : BtNode[T] = this.left
         this.left =  this.right
         this.right = this.left.right
         this.left.right = this.left.right
         var valueTemp : T = this.value
         this.value = this.right.value
         this.right.value = valueTemp
       }
       else{// Rotaçao LR
         left.left = left
         left.right = null
         right.right = this
         this.right = null
       }
     }
     else{
       if(factorRight < 0){ // Rotaçao RR
         right.right = this
         this.left = null
       }
       else{  // Rotaçao RL
         right.right = right
         right.left = null
         right.left = this
         this.right =null
       }
     }*/
  }

}

