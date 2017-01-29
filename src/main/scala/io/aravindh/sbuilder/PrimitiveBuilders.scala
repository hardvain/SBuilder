package io.aravindh.sbuilder
import SBuilder._
trait PrimitiveBuilders {
  implicit val intBuilder: SBuilder[Int] = createSBuilder[Int](0)
  implicit val stringBuilder : SBuilder[String] = createSBuilder[String]("")
  implicit val booleanBuilder: SBuilder[Boolean] = createSBuilder[Boolean](false)
  implicit val doubleBuilder: SBuilder[Double] = createSBuilder[Double](0.0)
  implicit val floatBuilder: SBuilder[Float] = createSBuilder[Float](0.0f)
}
