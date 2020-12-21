class CandidateFinder {

    fun combinationArr(pool: ArrayList<Int>, previous: ArrayList<Int>): ArrayList<ArrayList<Int>> {
        val store = ArrayList<ArrayList<Int>>()
        var currentPool = ArrayList(pool)
        for (item in pool) {
            val current = ArrayList(previous)
            current.add(item)
            store.add(current)
            currentPool = currentPool.drop(1).toCollection(arrayListOf())
            store.addAll(combinationArr(currentPool, current))
        }
        return store
    }

    fun solution(relation: Array<Array<String>>): Int {
        val first = relation[0].mapIndexed { index, s -> index }.toCollection(arrayListOf())

        val combinationArr = combinationArr(first, ArrayList())

        val candidateList = ArrayList<ArrayList<Int>>()
        combinationArr.sortBy { it.size }
        for (case in combinationArr) {
            val hashMap = HashMap<String, Array<String>>()
            var hasDuplicate = false
            if (candidateList.any { case.containsAll(it) }) {
                continue
            }
            for (row in relation) {
                val key = case.fold("") { acc, i -> "$acc,${row[i]}" }
                if (hashMap.containsKey(key)) {
                    hasDuplicate = true
                    break
                }
                hashMap[key] = row
            }
            if (!hasDuplicate) {
                candidateList.add(case)
            }
        }
        return candidateList.size
    }
}
