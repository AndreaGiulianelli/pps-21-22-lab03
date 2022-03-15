package u03

import org.junit.*
import org.junit.Assert.*
import Lists.*

class Es4Test {
  import List.*

  val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))

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
