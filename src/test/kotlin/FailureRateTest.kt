import org.junit.Test

internal class FailureRateTest{

    @Test
    fun first(){
        val failureRate = FailureRate()
        val solution = failureRate.solution(4, intArrayOf(1,1,1,1,2,2,3,4))
        println(solution.toList())
    }
}
