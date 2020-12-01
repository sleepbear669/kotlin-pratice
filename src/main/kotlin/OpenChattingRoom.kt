class LogEvent(val type: String, val uid: String)

class OpenChattingRoom {

    fun printLog(type: String, nickname: String): String {
        when (type) {
            "Enter" -> {
                return "${nickname}님이 들어왔습니다."
            }
            "Leave" -> {
                return "${nickname}님이 나갔습니다."
            }
        }
        return "에러"
    }

    fun solution(record: Array<String>): Array<String> {
        val uIdAndNicknameMap = HashMap<String, String>()
        val logArray = ArrayList<LogEvent>()
        record.map { it.split(" ") }.forEach {
            when (it[0]) {
                "Enter" -> {
                    logArray.add(LogEvent(it[0], it[1]))
                    uIdAndNicknameMap[it[1]] = it[2]
                }
                "Leave" -> {
                    logArray.add(LogEvent(it[0], it[1]))
                }
                "Change" -> {
                    uIdAndNicknameMap[it[1]] = it[2]
                }
            }
        }
        return logArray.map { printLog(it.type, uIdAndNicknameMap[it.uid]!!) }.toTypedArray()
    }
}
