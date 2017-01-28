package io.aravindh.sbuilder
import SBuilder._
import org.scalatest.{FreeSpec, Matchers}


class SBuilderSpec extends FreeSpec with Matchers{
  "SBuilder" - {
    "should create a default dummy value for string" in {
      assert(SBuilder[String].build === "string")
    }
    "should create a default dummy value for int" in {
      assert(SBuilder[Int].build === 0)
    }
    "should create a default dummy value for boolean" in {
      assert(SBuilder[Boolean].build === false)
    }
    "should create a default dummy value for double" in {
      assert(SBuilder[Double].build === 3.14)
    }
  }
}
