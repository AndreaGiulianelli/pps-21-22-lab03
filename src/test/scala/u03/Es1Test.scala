package u03

import org.junit.*
import org.junit.Assert.*
import Lists.*

class Es1Test {
  import List.*

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
}
