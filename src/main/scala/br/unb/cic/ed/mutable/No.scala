package br.unb.cic.ed.mutable

/*
  @brief Um simples tipo nó que armazena um valor e um ponteiro
  para o proximo elemento.

  @author nunesgrf
  @author brenfeliped
 */
class No[T: Manifest] {
  private var dado: T = _
  private var proximo: No[T] = null

  def setDado(_dado: T): Unit = this.dado = _dado
  def setProximo(_prox: No[T]): Unit = this.proximo = _prox
  def getDado(): Option[T] = Some(this.dado)
  def getProximo(): No[T] = this.proximo
}
