import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class TargetNumberTest{

    @Test
    fun solutionTest(){
        val targetNumber = TargetNumber()
        val case1 = intArrayOf(1, 1, 1, 1, 1)
        val case2 = intArrayOf(1)
        val solution1 = targetNumber.solution(case1, 3)
        val solution2 = targetNumber.solution(case2, 1)
        assertEquals(solution1, 5)
        assertEquals(solution2, 0)

    }
}
