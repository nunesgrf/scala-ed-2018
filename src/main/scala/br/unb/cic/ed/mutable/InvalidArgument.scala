package br.unb.cic.ed.mutable

/*
  @brieg final case class de Invalid Argument.

  @author rbonifacio
 */
final case class InvalidArgument(private val message: String = "",
                                 private val cause: Throwable = None.orNull) extends Exception(message, cause)
