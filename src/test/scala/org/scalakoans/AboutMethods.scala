package org.scalakoans

import support.KoanSuite

class AboutMethods extends KoanSuite {

  koan ("method declaration") {
    // a method can be defined within other methods
    def add2(i: Int): Int = {
      return i + 2
    }

    add2(2) should be(4)

    // meditate
    def add3(i : Int) : Int = {
      i + 3
    }
    add3(2) should be(5)
  }

  koan ("return not always necssary") {
    def add2(i: Int): Int = {
      i + 2
    }

    add2(3) should be(5)
  }

  koan ("return type necessity") {
    def add2(i: Int) = {
      i + 2
    }

    val returned = add2(4) 
    returned should be(6)
    returned.isInstanceOf[Int] should be(true)
  }

  koan ("nested methods") {

    def add2(i: Int) = {
      def add(x: Int, y: Int) = {
        x + y
      }

      add(2, i)
    }

    add2(5) should be (7)

    //meditate
    def add3(i : Int) = {
      3 + i
    }
    add3(2) should be(5)
  }

  koan ("method without a return") {
    var x = 2
    def add2ToX() {
      x += 2
    }

    add2ToX()

    x should be (4)
  }

  koan ("brackets around the method body aren't always necessary for simple expressions") {
    def add2(i: Int) = i + 2

    add2(2) should be (4)
  }

  koan ("named arguments") {
    def add2(i: Int) = i + 2

    add2(i=5) should be (7)

    // MERGE
    // arguments can therefore be used out of order
    def addToWordCount(word : String, i : Int) = {
      i + word.length()
    }
    addToWordCount(i = 3, word = "foo") should be (6)
  }

  koan ("default arguments") {
    def addNumbers(first: Int, second: Int = 2) = first + second

    addNumbers(3) should be (5)

    meditate
    // def addNumbers2(first: Int = 2, second: Int) = first + second
    // addNumbers2(3)
  }

  koan ("by-name arguments make lazy arguments") {
    var x = 0
    def addOneToXAndReturnX() = { x += 1; x }

    x should __
    addOneToXAndReturnX should __
    x should __

    def add2(i: => Int) = {
      2 + i
    }

    add2(addOneToXAndReturnX) should __

    x should __

    val i = add2 {
      3 + 4
    }

    i should __
  }

  koan ("operators are just methods") {
    val x = 2

    val i = x + 2
    i should __

    val j = x.+(3)
    j should __
  }

  koan ("methods can be invoked like operators") {
    val s = "hello"
    s.length should __

    (s length) should __

    (s contains "x") should __
  }

}
