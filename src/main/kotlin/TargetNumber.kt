class TargetNumber {
    fun findTargetNumber(numbers: IntArray, resultList: ArrayList<Int>, total: Int, depth: Int) {
        if (numbers.size == depth) {
            resultList.add(total)
            return
        }
        findTargetNumber(numbers, resultList, total + numbers[depth], depth + 1)
        findTargetNumber(numbers, resultList, total - numbers[depth], depth + 1)
    }

    fun solution(numbers: IntArray, target: Int): Int {
        val resultList = ArrayList<Int>()
        findTargetNumber(numbers, resultList, 0, 0)
        return resultList.filter { it == target }.size
    }
}
