import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class TranslateBracketsTest {

    @Test
    fun solution() {
        val translateBrackets = TranslateBrackets()
//        val solution = translateBrackets.solution("))((")
//        println(solution)
//        val solution1 = translateBrackets.solution("()")
//        println(solution1)
        val solution2 = translateBrackets.solution("()))((()")
        println(solution2)
    }

    @Test
    fun findPosition() {
        val translateBrackets = TranslateBrackets()
        val position = translateBrackets.findBalancedBracket("))((()")
        val position1 = translateBrackets.findBalancedBracket("")
        val position2 = translateBrackets.findBalancedBracket("()))((()")
        Assertions.assertEquals(position, 4)
        Assertions.assertEquals(position1, 1)
        Assertions.assertEquals(position2, 2)
    }

    @Test
    fun correctBracketTest() {
        val translateBrackets = TranslateBrackets()
        val result = translateBrackets.correctBracket("")
        val result1 = translateBrackets.correctBracket("))((")
        val result2 = translateBrackets.correctBracket("()()")
        val result3 = translateBrackets.correctBracket("((()))")
        Assertions.assertEquals(result, true)
        Assertions.assertEquals(result1, false)
        Assertions.assertEquals(result2, true)
        Assertions.assertEquals(result3, true)
    }
}
