### SBuilder
SBuilder is a library for generating random instances of case classes in scala. These instances can be used while writing tests. Example:

``` scala
import io.aravindh.sbuilder._
import SBuilder._
case class Person(name:String, age:Int)
assert(SBuilder[Person].build === Person("", 0))
```

SBuilder automatically assigns default values types for primitive types and any complex data types using those primitive types are recursively created. One
can provide a custom builder for any type by providing an implicit of type `SBuilder[A]` where `A` is the intended type. This library is in very basic stages. 
 
 ## Upcoming features
 * Ability to customize the default values by providing some predicates
 * Ability to mention the number of elements to be created if used against a collection