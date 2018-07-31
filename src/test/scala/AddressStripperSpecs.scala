import org.scalatest.{FunSuite, Matchers}

class AddressStripperSpecs extends FunSuite with Matchers {

  ignore("asd") {

    AddressStripper.strip("my address is 888 2ND AVE N") shouldBe "my address is ###"

  }
}
