data class Coordinate(val x: Int, val y: Int) {
    operator fun plus(coordinate: Coordinate): Coordinate {
        return Coordinate(x + coordinate.x, y + coordinate.y)
    }
}

class TileManger(tiles: List<Coordinate>, val size: Int) {
    var tiles = tiles
        private set

    fun getAll(): List<Coordinate> {
        return tiles.map { it + position }
    }

    var position = Coordinate(0, 0)

    fun moveTo(coordinate: Coordinate) {
        position = coordinate
    }

    fun rangeIn(rangeX: IntRange, rangeY: IntRange): List<Coordinate> {
        return getAll().filter { rangeX.contains(it.x) && rangeY.contains(it.y) }
    }

    fun rotate() {
        tiles.map { Coordinate(size - 1 - it.y, it.x) }.also { this.tiles = it }
    }
}

class LockAndKey {
    fun tileManagerGenerator(grid: Array<IntArray>, value: Int): TileManger {
        val tiles = ArrayList<Coordinate>()
        grid.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, state ->
                if (state == value) tiles.add(Coordinate(x, y))
            }
        }
        return TileManger(tiles, grid.size)
    }

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val keyTileManager = tileManagerGenerator(key, 1)
        val lockTileManager = tileManagerGenerator(lock, 0)
        val lockTiles = lockTileManager.getAll()
        val lockSize = lock.size
        val keySize = key.size
        val exploreRange = lockSize + keySize * 2
        val start = -keySize
        if (lockTiles.isEmpty()) return true
        for (rotate in 0..4) {
            keyTileManager.moveTo(Coordinate(start, start))
            for (i in 0..exploreRange) {
                for (j in 0..exploreRange) {
                    keyTileManager.moveTo(Coordinate(start + j, start + i))
                    val rangeInTiles = keyTileManager.rangeIn(IntRange(0, lockSize - 1), IntRange(0, lockSize - 1))
                    if (rangeInTiles.size == lockTiles.size && rangeInTiles.containsAll(lockTiles)) {
                        return true
                    }
                }
            }
            keyTileManager.rotate()
        }
        return false
    }
}
