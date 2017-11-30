import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class RomanNumeralsAcceptanceSpec : StringSpec() {
    init {

        "it kind of works" {
            val converter = RomanNumeralConverter()

            // @formatter:off
            val testTable = table(
                    headers("decimal",  "romanNumeral"),
                    //-----|-----------|------------------------
                    row    (47,         "XLVII"),
                    row    (123,        "CXXIII"),
                    row    (1998,       "MCMXCVIII"),
                    row    (2345,       "MMCCCXLV")
            )
            // @formatter:on

            forAll(testTable) { decimal, romanNumeral ->
                converter.convert(decimal) shouldBe romanNumeral
            }
        }

    }
}

