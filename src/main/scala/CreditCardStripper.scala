import scala.util.matching.Regex

trait Stripper {
  def strip(input: String): String
}

object CreditCardStripper extends Stripper {

  val MaskWith: String = (1 to 10).map(_ => "#").mkString("")

  val VisaRegex: String => String = input => """4[0-9]{6,}""".r.replaceAllIn(input, MaskWith)
  val MasterCardRegex: String => String = input => """[1-5][0-9]{5,}|222[1-9][0-9]{3,}|22[3-9][0-9]{4,}|2[3-6][0-9]{5,}|27[01][0-9]{4,}|2720[0-9]{3,}""".r.replaceAllIn(input, MaskWith)
  val AmericanExpress: String => String = input => """3[47][0-9]{5,}""".r.replaceAllIn(input, MaskWith)

  val maskers: Set[String => String] = Set(VisaRegex, MasterCardRegex, AmericanExpress)


  override def strip(input: String): String = {

    maskers.foldLeft(input) { (in, maskFn) => maskFn(in) }
  }
}
