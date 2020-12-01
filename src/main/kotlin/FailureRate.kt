class StageState(val stage: Int) {
    var remain: Int = 0
    var challenger: Int = 0

    fun failure(): Float {
        if (challenger == 0) return 0F
        return remain.div(challenger.toFloat())
    }
}

class FailureRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        val stateStateArray = Array(N) { index -> StageState(index + 1) }
        stages.filter { it <= N }.forEach { stateStateArray[it - 1].remain++ }
        (0 until N).forEach { i ->
            if (i == 0) {
                stateStateArray[i].challenger = stages.size
            } else {
                stateStateArray[i].challenger = stateStateArray[i - 1].challenger - stateStateArray[i - 1].remain
            }
        }
        stateStateArray.sortByDescending { it.failure() }
        return stateStateArray.map { it.stage }.toIntArray()
    }
}
