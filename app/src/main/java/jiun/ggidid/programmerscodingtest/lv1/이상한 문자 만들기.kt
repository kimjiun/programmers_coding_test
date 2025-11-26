package jiun.ggidid.programmerscodingtest.lv1

class Solution12930 {
    fun solution(s: String): String {
        println(s.split(" ").filter { it.isNotEmpty() && !it.contains("-") })

        var answer = s.split(" ").joinToString(" ") { word ->
            word
                .mapIndexed { index, char ->
                    if (index % 2 == 0) char.uppercase() else char.lowercase()
                }
                .joinToString("")
        }

        println(answer)
        return answer
    }
}

fun main() {
    val a = Solution12930()
    a.solution("try    hello  world")
}