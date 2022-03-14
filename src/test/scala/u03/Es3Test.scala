package u03


import org.junit.*
import org.junit.Assert.*
import Lists.*
import u02.Modules.*

class Es3Test {
  import List.*
  import Person.*

  @Test
  def testGetCourses(): Unit =
    assertEquals(Cons("english", Cons("math", Nil())),
      getCourses(Cons(Student("Andrea", 2000),
          Cons(Teacher("Mario", "english"),
          Cons(Student("Franco", 2000),
          Cons(Teacher("Luca", "math"), Nil()))))))
}
