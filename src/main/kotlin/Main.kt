import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter an integer: ")
    val number = scanner.nextInt()

    if (number in 0..999999) {
        val result = convertNumberToWords(number)
        println("In words: $result")
    } else {
        println("Input out of bounds. Please enter a six-digit integer or less.")
    }
}

fun convertNumberToWords(number: Int): String {
    val units = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = arrayOf("", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    if (number == 0) {
        return "zero"
    }

    var num = number
    var words = ""

    if (num >= 1000) {
        words += convertNumberToWords(num / 1000) + " thousand "
        num %= 1000
    }

    if (num >= 100) {
        words += units[num / 100] + " hundred "
        num %= 100
    }

    if (num >= 11 && num <= 19) {
        words += teens[num - 10] + " "
        // Set num to 0 to skip processing the units place
        num = 0
    } else if (num >= 20) {
        words += tens[num / 10] + " "
        num %= 10
    }

    if (num > 0) {
        words += units[num]
    }

    return words.trim()
}
