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
}
