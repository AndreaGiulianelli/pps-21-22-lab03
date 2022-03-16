package u03

import org.junit.*
import org.junit.Assert.*
import Lists.*

class ExerciseListTest {
  import List.*
  import u02.Optionals.Option.{None, Some}
  import u02.Modules.Person.{Student, Teacher}

  val higher = 100
  val middle = 50
  val lower = 20
  val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))

  @Test
  def testDrop(): Unit =
    assertEquals(Cons(3, Nil()),
      drop(Cons(1, Cons(2, Cons(3, Nil()))),2))

  @Test
  def testDropOverBound(): Unit =
    assertEquals(Nil(),
      drop(Cons(1, Cons(2, Cons(3, Nil()))),5))

  @Test
  def testAppend(): Unit =
    assertEquals(Cons(1, Cons(2, Cons(3, Cons(4, Nil())))),
      append(Cons(1, Cons(2, Cons(3, Nil()))), Cons(4, Nil())))

  @Test
  def testAppendEmptyRightSide(): Unit =
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))),
      append(Cons(1, Cons(2, Cons(3, Nil()))), Nil()))

  @Test
  def testAppendEmptyLeftSide(): Unit =
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))),
      append(Nil(), Cons(1, Cons(2, Cons(3, Nil())))))

  @Test
  def testAppendEmptyBothSide(): Unit =
    assertEquals(Nil(),
      append(Nil(), Nil()))

  @Test
  def testFlatMapSingleValue(): Unit =
    assertEquals(Cons(11, Cons(12, Cons(13, Nil()))),
      flatMap(Cons(10, Cons(11, Cons(12, Nil()))))(v => Cons(v + 1, Nil())))

  @Test
  def testFlatMapComplexValue(): Unit =
    assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))),
      flatMap(Cons(10, Cons(20, Cons(30, Nil()))))(v => Cons(v + 1, Cons(v + 2, Nil()))))

  @Test
  def testFilterWithFlatMap(): Unit =
    assertEquals(Cons(3, Nil()),
      filterWithFlatMap(Cons(1, Cons(2, Cons(3, Nil()))))(_ > 2))

  @Test
  def testMapWithFlatMap(): Unit =
    assertEquals(Cons(2, Cons(4, Cons(6, Nil()))),
      mapWithFlatMap(Cons(1, Cons(2, Cons(3, Nil()))))(_ * 2))

  @Test
  def testMax(): Unit =
    assertEquals(Some(higher), max(Cons(middle, Cons(higher, Cons(lower, Nil())))))

  @Test
  def testMaxFirst(): Unit =
    assertEquals(Some(higher), max(Cons(higher, Cons(middle, Cons(lower, Nil())))))

  @Test
  def testMaxLast(): Unit =
    assertEquals(Some(higher), max(Cons(lower, Cons(middle, Cons(higher, Nil())))))

  @Test
  def testMaxEmpty(): Unit =
    assertEquals(None(), max(Nil()))

  @Test
  def testGetCourses(): Unit =
    assertEquals(Cons("english", Cons("math", Nil())),
      getCourses(Cons(Student("Andrea", 2000),
        Cons(Teacher("Mario", "english"),
        Cons(Student("Franco", 2000),
        Cons(Teacher("Luca", "math"), Nil()))))))

  @Test
  def testFoldLeft(): Unit =
    assertEquals(-16, foldLeft(lst)(0)(_ - _))

  @Test
  def testReverse(): Unit =
    assertEquals(Cons(3, Cons(2, Cons(1, Nil()))),
      reverse(Cons(1, Cons(2, Cons(3, Nil())))))

  @Test
  def testFoldRight(): Unit =
    assertEquals(-8, foldRight(lst)(0)(_ - _))

  @Test
  def testFoldLeftWithString(): Unit =
    assertEquals("num: 3num: 7num: 1num: 5", foldLeft(lst)("")((acc, x) => s"${acc}num: ${x}"))

  @Test
  def testFoldRightWithString(): Unit =
    assertEquals("num: 5num: 1num: 7num: 3", foldRight(lst)("")((x, acc) => s"${acc}num: ${x}"))

  @Test
  def testFoldRight2(): Unit =
    assertEquals(-8, foldRight2(lst)(0)(_ - _))

  @Test
  def testFoldRight2WithString(): Unit =
    assertEquals("num: 5num: 1num: 7num: 3", foldRight2(lst)("")((x, acc) => s"${acc}num: ${x}"))
}
