import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class RomanNumeralsSpec : StringSpec() {
    init {

        "it converts decimal to roman numeral" {
            val converter = RomanNumeralConverter()

            // @formatter:off
            val testTable = table(
                    headers("decimal",  "romanNumeral"),
                    // == simplest numerals ==
                    //-----|-----------|------------------------
                    row    (0,          ""),
                    row    (1,          "I"),
                    row    (5,          "V"),
                    row    (10,         "X"),
                    row    (50,         "L"),
                    row    (100,        "C"),
                    row    (500,        "D"),
                    row    (1000,       "M"),
                   // == repetition rule ==
                    //-----|-----------|------------------------
                    row    (2,          "II"),
                    row    (3,          "III"),
                    row    (20,         "XX"),
                    row    (30,         "XXX"),
                    row    (200,        "CC"),
                    row    (300,        "CCC"),
                    row    (2000,       "MM"),
                    row    (3000,       "MMM"),
                    // == decreasing rule ==
                    //-----|-----------|------------------------
                    row    (6,          "VI"),
                    row    (7,          "VII"),
                    row    (8,          "VIII"),
                    row    (11,         "XI"),
                    row    (12,         "XII"),
                    row    (13,         "XIII"),
                    row    (15,         "XV"),
                    row    (16,         "XVI"),
                    row    (17,         "XVII"),
                    row    (18,         "XVIII"),
                    row    (337,        "CCCXXXVII"),
                    // == subtraction rule ==
                    //-----|-----------|------------------------
                    row    (4,          "IV"),
                    row    (9,          "IX"),
                    row    (40,         "XL"),
                    row    (90,         "XC"),
                    row    (400,        "CD"),
                    row    (900,        "CM"),
                    row    (999,        "CMXCIX")
            )
            // @formatter:on

            forAll(testTable) { decimal, romanNumeral ->
                converter.convert(decimal) shouldBe romanNumeral
            }
        }

    }
}