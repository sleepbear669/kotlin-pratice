class CaesarCipher {

    fun caesarCipher(cryptogram: String, n: Int): String {
        val a = 'a'.toInt()
        val A = 'A'.toInt()
        val space = ' '.toInt()
        val reduce = cryptogram
            .toCharArray()
            .map {
                val charInt = it.toInt()
                when {
                    charInt >= a -> {
                        if (charInt - a + n == 0) a
                        else a + ((charInt - a + n)).rem(26)
                    }
                    charInt >= A -> {
                        if (charInt - A + n == 0) A
                        else {
                            A + (charInt - A + n).rem(26)
                        }
                    }
                    else -> space
                }
            }
            .map(Int::toChar)
            .toCharArray()
        return String(reduce)
    }


}
