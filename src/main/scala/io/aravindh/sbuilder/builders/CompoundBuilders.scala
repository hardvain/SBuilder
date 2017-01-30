package io.aravindh.sbuilder.builders

import io.aravindh.sbuilder.SBuilder
import io.aravindh.sbuilder.SBuilder._
trait CompoundBuilders{
  implicit def seqBuilder[A](implicit sBuilder: SBuilder[A]) : SBuilder[Seq[A]] = createSBuilder[Seq[A]](Seq[A](sBuilder.build))
}