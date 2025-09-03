package $package$

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.featurespec.AnyFeatureSpec

class Test extends AnyFunSuite {

  test("toUpperCase") {
    assert("wonderful world".toUpper == "WONDERFUL WORLD")
  }

}
