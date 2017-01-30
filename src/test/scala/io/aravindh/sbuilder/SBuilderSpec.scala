package io.aravindh.sbuilder

import org.scalatest.{FreeSpec, Matchers}

class SBuilderSpec extends FreeSpec with Matchers {
  case class Person(name: String, age: Int, weight: Double, isProgrammer: Boolean)
  case class Family(mother:Person, father:Person, son:Person, daughter:Person)
  "SBuilder" - {
    "For Primitive Types" - {
      "should create a default dummy value for string" in {
        assert(SBuilder[String].build === "")
      }
      "should create a default dummy value for int" in {
        assert(SBuilder[Int].build === 0)
      }
      "should create a default dummy value for boolean" in {
        assert(SBuilder[Boolean].build === false)
      }
      "should create a default dummy value for double" in {
        assert(SBuilder[Double].build === 0.0)
      }
    }
    "For Case Classes" - {
      "should create a default dummy value for the case class by using dummy value for its primitives" in {
        assert(SBuilder[Person].build === Person("", 0, 0.0, false))
      }
      "should create a default dummy value for a complex case class by using dummy value for its primitives" in {
        val person = Person("", 0, 0.0, false)
        assert(SBuilder[Family].build === Family(person, person, person, person))
        assert(SBuilder[Seq[Person]].build === Seq[Person](person))
      }
    }
  }
}

