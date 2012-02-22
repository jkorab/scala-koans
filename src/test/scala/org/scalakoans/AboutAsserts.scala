package org.scalakoans

import support.KoanSuite

class AboutAsserts extends KoanSuite {

  koan ("should be true") {
    assert(true)   // should be true
  }

  koan ("should be true with message") {
    assert(true, "This should be true")
  }

  koan ("should be true with should matchers") {
    true should be (true)  // should be true
  }

  koan ("should match two equal values") {
    val v1 = 4
    val v2 = 4

    //meditate
    // here we are concerned with == equality, this is the same as .equals in Java
    v1 should be(v2)
  }

  koan("can also use equal as a matcher") {
    val v1 = 4
    val v2 = 4

    // be() is the same as equals()
    v1 should equal(v2)
  }

  koan ("sometimes we expect you to fill in the values") {
    (1+1) should be(2)
  }
}
