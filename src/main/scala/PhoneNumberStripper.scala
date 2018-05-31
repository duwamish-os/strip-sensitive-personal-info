import scala.util.matching.Regex

object PhoneNumberStripper extends Stripper {

  val Mask = "###-###-####"

  private val Pattern1 = """\d{10}"""
  private val Pattern2 = """(?:\d{3}-){2}\d{4}"""
  private val Pattern3 = """\(\d{3}\)\d{3}-?\d{4}"""

  private val PhoneNumberRegex: Regex = s"""$Pattern1|$Pattern2|$Pattern3""".r

  override def strip(input: String): String = PhoneNumberRegex.replaceAllIn(input, Mask)

}
