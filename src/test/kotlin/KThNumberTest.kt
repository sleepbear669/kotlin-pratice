import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class KThNumberTest {
    @Test
    fun firstTest() {
        val kThNumber = KThNumber()
        val find = kThNumber.find(intArrayOf(1, 5, 2, 6, 3, 7, 4), intArrayOf(2, 5, 3))
        Assertions.assertEquals(find, 5)
    }
}


