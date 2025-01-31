package u03

import u02.Modules.{Person, isStudent}

object Lists extends App:

  // A generic linkedlist
  enum List[E]:
    case Cons(head: E, tail: List[E])
    case Nil()
  // a companion object (i.e., module) for List
  object List:
    import u02.Optionals.Option
    import u02.Optionals.Option.Some
    import u02.Optionals.Option.None

    def sum(l: List[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _ => 0

    def map[A, B](l: List[A])(mapper: A => B): List[B] = l match
      case Cons(h, t) => Cons(mapper(h), map(t)(mapper))
      case Nil() => Nil()

    def filter[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match
      case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
      case Cons(_, t) => filter(t)(pred)
      case Nil() => Nil()

    @annotation.tailrec
    def drop[A](l: List[A], n: Int): List[A] = l match
      case Cons(h, t) if n > 0 => drop(t, n - 1)
      case _ => l

    def append[A](left: List[A], right: List[A]): List[A] = left match
      case Cons(lh, lt) => Cons(lh, append(lt, right))
      case Nil() => right

    def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match
      case Cons(h, t) => append(f(h), flatMap(t)(f))
      case _ => Nil()

    def filterWithFlatMap[A](l: List[A])(pred: A => Boolean): List[A] =
      flatMap(l)({case v if pred(v) => Cons(v, Nil()); case _ => Nil()})

    def mapWithFlatMap[A, B](l: List[A])(mapper: A => B): List[B] =
      flatMap(l)(v => Cons(mapper(v), Nil()))

    def max(l: List[Int]): Option[Int] =
      @annotation.tailrec
      def _max(t: List[Int], max: Int): Option[Int] = t match
        case Cons(h, t) if max > h => _max(t, max)
        case Cons(h, t) => _max(t, h)
        case Nil() => Some(max)

      l match
        case Cons(h, t) => _max(t, h)
        case _ => None()

    def getCourses(l: List[Person]): List[String] =
      flatMap(l)({case Person.Teacher(name, course) => Cons(course, Nil()); case _ => Nil()})

    /*
      f take as arguments the current accumulator and the new element to fold.
      So it's a function that fold the new value to the previous calculated one.
    */
    def foldLeft[A, B](l: List[A])(i: B)(f: (B, A) => B): B =
      @annotation.tailrec
      def _f(l: List[A], f: (B, A) => B, acc: B): B = l match
        case Cons(h, t) => _f(t, f, f(acc, h))
        case Nil() => acc

      l match
        case Nil() => i
        case Cons(h, t) => _f(t, f, f(i, h))

    // foldRight defined in terms of foldLeft (as in the slides)
    def foldRight[A, B](l: List[A])(i: B)(f: (A, B) => B): B =
      foldLeft(reverse(l))(i)((x, y) => f(y, x))

    // Second version of foldRight
    def foldRight2[A, B](l: List[A])(i: B)(f: (A, B) => B): B = l match
      case Cons(h, t) => f(h, foldRight2(t)(i)(f))
      case Nil() => i

    def reverse[A](l: List[A]): List[A] = l match
      case Cons(h, t) => append(reverse(t), Cons(h, Nil()))
      case Nil() => Nil()



  val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
  println(List.sum(l)) // 60

  import List.*

  println(sum(map(filter(l)(_ >= 20))(_ + 1))) // 21+31 = 52
