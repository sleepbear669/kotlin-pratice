import org.junit.jupiter.api.Test

internal class KakaoCraneTest {

    @Test
    fun orderByColumn() {
        val kakaoCrane = KakaoCrane()
        val board = arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 3),
            intArrayOf(0, 2, 5, 0, 1),
            intArrayOf(4, 2, 4, 4, 2),
            intArrayOf(3, 5, 1, 3, 1)
        )
        val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        kakaoCrane.solution(board, moves)
    }


}

//  4 2 4
