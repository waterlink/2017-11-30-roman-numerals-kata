class RomanNumeralConverter {

    companion object {

        private val simplestNumerals = mapOf(
                1 to "I",
                5 to "V",
                10 to "X",
                50 to "L",
                100 to "C",
                500 to "D",
                1000 to "M"
        )
        private val leftOver = mapOf(
                4 to "IV",
                9 to "IX",
                40 to "XL",
                90 to "XC",
                400 to "CD",
                900 to "CM"
        )
    }

    fun convert(decimal: Int): String {
        if (decimal == 0) {
            return ""
        }

        return leftOver[decimal] ?:
                simplestNumerals[decimal] ?:
                repeatedRule(decimal) ?:
                decreasingRule(decimal) ?:
                "?"
    }

    private fun repeatedRule(decimal: Int): String? {

        val repeatingNumber = simplestNumerals.keys.findLast { it < decimal }!!

        val simpleRomanNumeral = simplestNumerals[repeatingNumber]!!

        if (decimal % repeatingNumber == 0) {
            val range = 0 until decimal / repeatingNumber
            return range.joinToString("") { simpleRomanNumeral }
        }

        return null
    }

    private fun decreasingRule(decimal: Int): String? {

        val biggestLeftOverNumber = leftOver.keys.findLast { it < decimal }!!
        val biggestSimplestNumber = simplestNumerals.keys.findLast { it < decimal }!!

        if (biggestLeftOverNumber > biggestSimplestNumber) {

            val simpleRomanNumeral = leftOver[biggestLeftOverNumber]!!

            return simpleRomanNumeral + convert(decimal - biggestLeftOverNumber)

        } else {


            val simpleRomanNumeral = simplestNumerals[biggestSimplestNumber]!!

            return simpleRomanNumeral + convert(decimal - biggestSimplestNumber)
        }
    }

}