import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class StringCompressorTest {

    @Test
    fun solutionTest() {
        val stringCompressor = StringCompressor()
        val solution = stringCompressor.solution("abc")
        val solution1 = stringCompressor.solution("aaa")
        val solution2 = stringCompressor.solution("abababc")
        val solution3 = stringCompressor.solution("aabbaccc")
        val solution4 = stringCompressor.solution("ababcdcdababcdcd")
        assertEquals(3, solution)
        assertEquals(2, solution1)
        assertEquals(4, solution2)
        assertEquals(7, solution3)
        assertEquals(9, solution4)
    }
}
