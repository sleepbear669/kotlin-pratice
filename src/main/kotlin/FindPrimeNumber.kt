import kotlin.math.sqrt

class FindPrimeNumber {

    private val numberSet: HashSet<Int> = HashSet()

    fun isPrime(number: Int): Boolean {
        if (number == 0 || number == 1) return false
        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number.rem(i) == 0) {
                return false
            }
        }
        return true
    }

    fun findNumbers(numbers: String, previous: String) {
        for (i in numbers.indices) { // 반복 사용할수 숫자만큼
            val numberString = previous + numbers[i] // 이전의 상태에서 지금 숫자 하나씩 3,4 12  3,4
            val number = numberString.toInt()
//            if (isPrime(number)) {
//                numberSet.add(number)
//            }
            findNumbers(numbers.removeRange(i, i + 1), numberString)
        }
    }

    fun solution(numbers: String): Int {
        findNumbers(numbers, "")
        val size = numberSet.size
        numberSet.clear()
        return size
    }
}
