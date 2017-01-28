package io.aravindh.sbuilder

import shapeless.{Generic, HList, HNil}

trait Builder[A] {
  def build: A
}

object Builder{
  def apply[A](implicit builder: Builder[A]) = builder

  def createBuilder[A](a: A) = new Builder[A] {
    override def build: A = a
  }

  implicit val stringBuilder: Builder[String] = createBuilder("string")
  implicit val intBuilder: Builder[Int] = createBuilder(1)
  implicit val doubleBuilder: Builder[Double] = createBuilder(1.0)
  implicit val booleanBuilder: Builder[Boolean] = createBuilder(true)

  implicit val hnilBuilder: Builder[HNil] = new Builder[HNil] {
    override def build: HNil = HNil
  }

  implicit def hlistBuilder[H, T <: HList](implicit hBuilder: Builder[H], tBuilder: Builder[T]): Builder[shapeless.::[H, T]] =
    new Builder[shapeless.::[H, T]] {
      override def build = hBuilder.build :: tBuilder.build
    }

  implicit def genericBuilder[A, Repr <: HList](implicit gen: Generic.Aux[A, Repr], builder: Builder[Repr]): Builder[A] = {
    new Builder[A] {
      override def build = gen.from(builder.build)
    }
  }
}