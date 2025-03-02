package $package$

import org.scalatest.funsuite.AnyFunSuite

class Test extends AnyFunSuite {  
  
  test("toUpperCase") {  
    assert("wonderful world".toUpper == "WONDERFUL WORLD")
  }

}
