class Code(val value: String) {
    var count = 1
        private set

    fun add() {
        count++
    }

    override fun toString(): String {
        var suffix = ""
        if (count > 1) suffix = count.toString()
        return "$value$suffix"
    }
}

class StringCompressor {
    fun solution(s: String): Int {
        var answer = s.length
        for (i in 1..(s.length / 2)) {
            val codeList = ArrayList<Code>()
            val r = s.chunked(i)
            codeList.add(Code(""))
            for (w in r) {
                val last = codeList.get(codeList.lastIndex)
                if (last.value == w) {
                    last.add()
                } else {
                    codeList.add(Code(w))
                }
            }
            val compressor = codeList.fold("") { acc, code -> acc + code.toString() }
            if (compressor.length < answer) answer = compressor.length
        }
        return answer
    }
}
