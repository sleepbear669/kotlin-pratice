class SpyDisguise {
    fun solution(clothes: Array<Array<String>>): Int {
        val clothMap: HashMap<String, HashSet<String>> = HashMap()

        for (clothInfo in clothes) {
            val type = clothInfo[1]
            val cloth = clothInfo[0]
            if (!clothMap.containsKey(type)) {
                clothMap[type] = HashSet()
            }
            clothMap[type]!!.add(cloth)
        }
        val combination = clothMap.values.map { it.size }.reduce { acc, i -> acc * i }
        return combination - 1  + clothes.size
    }
}
