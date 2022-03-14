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
}
