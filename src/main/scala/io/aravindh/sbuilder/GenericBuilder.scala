package io.aravindh.sbuilder

import shapeless.{Generic, HList, Lazy}

trait GenericBuilder {
  implicit def genericBuilder[A, Repr <: HList](implicit gen: Lazy[Generic.Aux[A, Repr]], builder: Lazy[SBuilder[Repr]]): SBuilder[A] = {
    new SBuilder[A] {
      override def build = gen.value.from(builder.value.build)
    }
  }
}
