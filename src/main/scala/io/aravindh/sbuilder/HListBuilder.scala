package io.aravindh.sbuilder

import shapeless.{HList, HNil}
import SBuilder._

trait HListBuilder {
  implicit val hnilBuilder: SBuilder[HNil] = createSBuilder[HNil](HNil)

  implicit def hlistBuilder[H, T <: HList](implicit hBuilder: SBuilder[H], tBuilder: SBuilder[T]): SBuilder[shapeless.::[H, T]] =
    new SBuilder[shapeless.::[H, T]] {
      override def build = hBuilder.build :: tBuilder.build
    }
}
