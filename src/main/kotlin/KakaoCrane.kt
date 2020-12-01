class KakaoCrane {

    fun solution(board: Array<IntArray>, moves: IntArray): Int {

        val basket = moves.map {
            val indexOfFirst = board.indexOfFirst { ints -> ints[it - 1] != 0 }
            if (indexOfFirst >= 0) {
                val item = board[indexOfFirst][it - 1]
                board[indexOfFirst][it - 1] = 0
                return@map item
            }
            return@map 0
        }.toIntArray()

        var count = 0
        for (i in 0 until basket.size - 1) {
            for (j in 0 until basket.size - 1) {
                for (k in j + 1 until basket.size) {
                    if (basket[j] == 0) break
                    if (basket[k] == 0) continue
                    if (basket[j] != basket[k]) break
                    if (basket[j] == basket[k]) {
                        basket[j] = 0
                        basket[k] = 0
                        count++
                        break
                    }
                }
            }
        }
        return count * 2
    }


}
