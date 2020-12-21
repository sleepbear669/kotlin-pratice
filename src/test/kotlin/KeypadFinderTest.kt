import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class KeypadFinderTest{
    @Test
    fun solution(){
        val keypadFinder = KeypadFinder()
        val solution = keypadFinder.solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "left")
        assertEquals("LRLLLRLLRRL", solution)
    }
}
