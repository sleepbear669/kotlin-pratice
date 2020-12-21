import org.junit.Test
import kotlin.test.assertEquals

internal class LockAndKeyTest {

    @Test
    fun solution() {
        val lockAndKey = LockAndKey()
        val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
        val lock = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
        lockAndKey.solution(key, lock)
    }

    @Test
    fun moveTiles() {
        val lockAndKey = LockAndKey()
        val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
        val keyTileManager = lockAndKey.tileManagerGenerator(key, 1)

        keyTileManager.moveTo(Coordinate(1, 1))

        val tiles = keyTileManager.getAll()
        assertEquals(Coordinate(1, 2), tiles[0])
        assertEquals(Coordinate(2, 3), tiles[1])
        assertEquals(Coordinate(3, 3), tiles[2])

        keyTileManager.moveTo(Coordinate(0, 0))

        val tiles2 = keyTileManager.getAll()
        assertEquals(Coordinate(0, 1), tiles2[0])
        assertEquals(Coordinate(1, 2), tiles2[1])
        assertEquals(Coordinate(2, 2), tiles2[2])

        keyTileManager.moveTo(Coordinate(-2, -2))

        val tiles3 = keyTileManager.getAll()
        assertEquals(Coordinate(-2, -1), tiles3[0])
        assertEquals(Coordinate(-1, 0), tiles3[1])
        assertEquals(Coordinate(0, 0), tiles3[2])
    }

    @Test
    fun findRangeInTiles() {
        val lockAndKey = LockAndKey()
        val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
        val keyTileManager = lockAndKey.tileManagerGenerator(key, 1)

        val rangeIn = keyTileManager.rangeIn(IntRange(0, 1), IntRange(0, 1))

        assertEquals(1, rangeIn.size)
        assertEquals(Coordinate(0, 1), rangeIn[0])

        keyTileManager.moveTo(Coordinate(-3, -3))

        val rangeIn1 = keyTileManager.rangeIn(IntRange(0, 1), IntRange(0, 1))

        assertEquals(0, rangeIn1.size)
    }

    @Test
    fun rotateTiles() {
        val lockAndKey = LockAndKey()
        val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
        val keyTileManager = lockAndKey.tileManagerGenerator(key, 1)
        println(keyTileManager.getAll())
        keyTileManager.rotate()
        val tiles = keyTileManager.getAll()
        println(tiles)
        val a = listOf(Coordinate(1, 2), Coordinate(2, 2))
        val b = listOf(Coordinate(2, 2), Coordinate(1, 2))
        val c = listOf(Coordinate(1, 2), Coordinate(2, 2))
        println(a == b)
        println(a == c)
        println(a.containsAll(b))
    }

}
