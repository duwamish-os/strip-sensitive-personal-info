import org.scalatest.{FunSuite, Matchers}

class PhoneNumberStripperSpecs extends FunSuite with Matchers {

  test("phone number") {

    PhoneNumberStripper.strip("my number is 888-888-8888 and its seattle number") shouldBe "my number is ###-###-#### and its seattle number"
    PhoneNumberStripper.strip("my number is 8888888888 and its seattle number") shouldBe "my number is ###-###-#### and its seattle number"
    PhoneNumberStripper.strip("my number is (888)888-8888 and its seattle number") shouldBe "my number is ###-###-#### and its seattle number"

    PhoneNumberStripper.strip("""{"phoneNumber": "888-888-8888"}""") shouldBe """{"phoneNumber": "###-###-####"}"""

  }
}
