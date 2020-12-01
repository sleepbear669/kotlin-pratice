class KThNumber {

    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { this.find(array, it) }.toIntArray()
    }

    fun find(array: IntArray, command: IntArray): Int {
        val list = array.slice(IntRange(command[0] - 1, command[1] - 1)).sorted()
        return list[command[2] - 1]
    }

}
