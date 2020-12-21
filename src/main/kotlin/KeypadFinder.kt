import kotlin.math.abs

val KEYPAD_LIST = arrayOf(
    intArrayOf(1, 2, 3),
    intArrayOf(4, 5, 6),
    intArrayOf(7, 8, 9),
    intArrayOf(11, 0, 12)
)

data class Position(val x: Int, val y: Int) {
    operator fun minus(position: Position?): Int {
        if (position == null) return 0
        val xDistance = abs(x - position.x)
        val yDistance = abs(y - position.y)
        return xDistance + yDistance
    }
}

class KeypadFinder {
    fun solution(numbers: IntArray, hand: String): String {
        val keypadMap = HashMap<Int, Position>()
        for (i in KEYPAD_LIST.indices) {
            for (j in KEYPAD_LIST[i].indices) {
                keypadMap[KEYPAD_LIST[i][j]] = Position(i, j)
            }
        }
        var leftPosition = keypadMap[11]!!
        var rightPosition = keypadMap[12]!!
        val leftPad = arrayOf(1, 4, 7)
        val rightPad = arrayOf(3, 6, 9)
        var answer = ""
        for (number in numbers) {
            val current = keypadMap[number]!!
            val leftDistance = leftPosition.minus(current)
            val rightDistance = rightPosition.minus(current)
            when {
                leftPad.contains(number) -> {
                    answer += "L"
                    leftPosition = current
                }
                rightPad.contains(number) -> {
                    answer += "R"
                    rightPosition = current
                }
                leftDistance < rightDistance -> {
                    answer += "L"
                    leftPosition = current
                }
                leftDistance > rightDistance -> {
                    answer += "R"
                    rightPosition = current
                }
                (leftDistance == rightDistance) && hand == "left" -> {
                    answer += "L"
                    leftPosition = current
                }
                (leftDistance == rightDistance) && hand == "right" -> {
                    answer += "R"
                    rightPosition = current
                }
            }
        }
        return answer
    }
}
