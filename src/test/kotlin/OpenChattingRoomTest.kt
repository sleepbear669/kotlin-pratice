import org.junit.Test

internal class OpenChattingRoomTest {

    @Test
    fun solutionTest() {
        val openChattingRoom = OpenChattingRoom()
        val solution = openChattingRoom.solution(
            arrayOf(
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            )
        )
        solution.forEach { println(it) }
    }
}
