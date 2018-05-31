import org.scalatest.{FunSuite, Matchers}

class CreditCardStripperSpec extends FunSuite with Matchers {

  val Mask16 = (1 to 16).map(_ => "#").mkString("")
  val Mask19 = (1 to 19).map(_ => "#").mkString("")

  test("strips VISA credit card number") {
    CreditCardStripper.strip("my credit card number is 4916544377668662 and") shouldBe s"my credit card number is $Mask16 and"
    CreditCardStripper.strip("my credit card number is 4556585647517333728 and") shouldBe s"my credit card number is $Mask16 and"

  }

  test("strips MasterCard credit card number") {
    val input = "my credit card number is 2720991816886787 what is"
    CreditCardStripper.strip(input) shouldBe s"my credit card number is $Mask16 what is"
  }

  test("strips AE credit card number") {
    val input = "my credit card number is 2720991816886787"
    CreditCardStripper.strip(input) shouldBe s"my credit card number is $Mask16"
  }

}
