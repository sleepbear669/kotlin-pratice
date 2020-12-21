import org.junit.Test
import kotlin.test.assertEquals

internal class FindPrimeNumberTest {

    @Test
    fun solutionTest() {
        val findPrimeNumber = FindPrimeNumber()
        val case1 = "1234"
//        val case2 = "17"

        val solution1 = findPrimeNumber.solution(case1)
//        val solution2 = findPrimeNumber.solution(case2)
        assertEquals(2, solution1)
//        assertEquals(3, solution2)
    }

    @Test
    fun isPrimeTest() {
        val findPrimeNumber = FindPrimeNumber()
        val case1 = findPrimeNumber.isPrime(3)
        val case2 = findPrimeNumber.isPrime(6)
        val case3 = findPrimeNumber.isPrime(7)
        val case4 = findPrimeNumber.isPrime(2)
        val case5 = findPrimeNumber.isPrime(1)
        val case6 = findPrimeNumber.isPrime(0)
        assertEquals(true, case1)
        assertEquals(false, case2)
        assertEquals(true, case3)
        assertEquals(true, case4)
        assertEquals(false, case5)
        assertEquals(false, case6)
    }

}
