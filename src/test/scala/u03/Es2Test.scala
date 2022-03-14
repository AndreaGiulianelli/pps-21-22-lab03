package u03

import org.junit.*
import org.junit.Assert.*
import Lists.*

class Es2Test {
  import List.*
  import u02.Optionals.Option.*

  val higher = 100
  val middle = 50
  val lower = 20

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
}