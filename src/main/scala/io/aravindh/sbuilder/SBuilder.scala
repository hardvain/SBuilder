package io.aravindh.sbuilder

import shapeless.{Generic, HList, HNil, Lazy}
import SBuilder._
import scala.annotation.implicitNotFound

@implicitNotFound(msg = "Cannot find SBuilder type class for ${A}")
trait SBuilder[A] {
  def build: A
}

object SBuilder extends GenericBuilder with HListBuilder with PrimitiveBuilders {
  def apply[A: SBuilder] = implicitly[SBuilder[A]]

  private[sbuilder] def createSBuilder[A](a: A) = new SBuilder[A] {
    override def build: A = a
  }
}






