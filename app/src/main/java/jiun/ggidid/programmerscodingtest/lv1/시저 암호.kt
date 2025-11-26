package jiun.ggidid.programmerscodingtest.lv1

class Solution12926 {
    fun solution(s: String, n: Int): String {
        val lowerChar = "abcdefghijklmnopqrstuvwxyz"
        val upperChar = lowerChar.uppercase()
        var answer =  s.map { ch ->
            println("ch : $ch")
            val aa =when {
                lowerChar.contains(ch) -> {
                    println("lowerChar")
                    val index = lowerChar.indexOf(ch)
                    if(index + n >= lowerChar.length){
                        lowerChar[index + n - lowerChar.length].toString()
                    }
                    else {
                        lowerChar[index + n].toString()
                    }
                }
                upperChar.contains(ch) -> {
                    println("upperChar")
                    val index = upperChar.indexOf(ch)

                    if(index + n >= upperChar.length){
                        upperChar[index + n - upperChar.length].toString()
                    }
                    else {
                        upperChar[index + n].toString()
                    }
                }
                else -> {
                    println("else")
                    ch
                }
            }
            println("aa : $aa")

            aa
        }.joinToString("")

        println(answer)

        return answer
    }
}

fun main() {
    val a = Solution12926()
    a.solution("AB", 1)
//    a.solution("z", 1)
//    a.solution("a B z", 4)
}