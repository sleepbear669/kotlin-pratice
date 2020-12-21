import kotlin.math.max

class Supoja(val name: Int, private val pattern: IntArray, private val answers: IntArray) {
    var score: Int = 0

    fun markAnswer(): Int {
        for (i in answers.indices) {
            if (correct(i, answers[i])) {
                score++
            }
        }
        return score
    }

    fun correct(index: Int, answer: Int): Boolean {
        val patternIndex = index % pattern.size
        return answer == pattern[patternIndex]
    }
}

class TrialExam {
    fun solution(answers: IntArray): IntArray {
        val supoja1 = Supoja(1, intArrayOf(1, 2, 3, 4, 5), answers)
        val supoja2 = Supoja(2, intArrayOf(2, 1, 2, 3, 2, 4, 2, 5), answers)
        val supoja3 = Supoja(3, intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5), answers)
        var maxCount = 0
        val supojaList = listOf<Supoja>(supoja1, supoja2, supoja3)

        for (supoja in supojaList) {
            val score = supoja.markAnswer()
            maxCount = max(maxCount, score)
        }

        return supojaList.filter { it.score == maxCount }.map { it.name }.toIntArray()
    }
}
