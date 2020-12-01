import java.util.*

class TranslateBrackets {

    fun solution(p: String): String {
        if (p.isEmpty()) return ""
        val position = findBalancedBracket(p)
        val u = p.slice(IntRange(0, position - 1))
        val v = p.slice(IntRange(position, p.length - 1))
        return if (correctBracket(u)) {
            u + solution(v)
        } else {
            val a = u.drop(1).dropLast(1).toCharArray().map {
                when (it) {
                    '(' -> ')'
                    else -> '('
                }
            }.toCharArray()
            "(${solution(v)})" + String(a)
        }
    }

    fun findBalancedBracket(p: String): Int {
        var close = 0
        var open = 0
        var position = 1
        for (c in p) {
            when (c) {
                '(' -> {
                    open++
                }
                ')' -> {
                    close++
                }
            }
            if (close == open) break
            position++
        }
        return position
    }

    fun correctBracket(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            if (!stack.isEmpty() && stack.peek() == '(' && it == ')') {
                stack.pop()
            } else {
                stack.add(it)
            }
        }
        return stack.isEmpty()
    }
}
