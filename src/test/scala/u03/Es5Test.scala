package u03

import org.junit.*
import org.junit.Assert.*
import Streams.*
import Lists.*

class Es5Test {
  import List.*;

  @Test
  def testStreamDrop(): Unit =
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))),
      Stream.toList(Stream.drop(Stream.take(Stream.iterate(0)(_ + 1))(10))(6)))
}
