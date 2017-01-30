package io.aravindh.sbuilder

import builders._
import scala.annotation.implicitNotFound

@implicitNotFound(msg = "Cannot find SBuilder type class for ${A}")
trait SBuilder[A] {
  def build: A
}

object SBuilder extends GenericBuilder with HListBuilder with PrimitiveBuilders with CompoundBuilders{
  def apply[A: SBuilder] = implicitly[SBuilder[A]]

  private[sbuilder] def createSBuilder[A](a: A) = new SBuilder[A] {
    override def build: A = a
  }
}






