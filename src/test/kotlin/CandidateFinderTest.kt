import org.junit.Test
import org.junit.jupiter.api.Assertions
import kotlin.test.asserter

internal class CandidateFinderTest {

    @Test
    fun solutionTest() {
        val candidateFinder = CandidateFinder()
        val relation = arrayOf(
            arrayOf("100", "ryan", "music", "2"),
            arrayOf("200", "apeach", "math", "2"),
            arrayOf("300", "tube", "computer", "3"),
            arrayOf("400", "con", "computer", "4"),
            arrayOf("500", "muzi", "music", "3"),
            arrayOf("600", "apeach", "music", "2"),
        )
        val relation1 = arrayOf(
            arrayOf("a","aa"),
            arrayOf("aa","a"),
            arrayOf("a","a"),
        )
        val solution = candidateFinder.solution(relation)
        val solution1 = candidateFinder.solution(relation1)
        Assertions.assertEquals(solution, 2)
        Assertions.assertEquals(solution1, 1)

    }
}
