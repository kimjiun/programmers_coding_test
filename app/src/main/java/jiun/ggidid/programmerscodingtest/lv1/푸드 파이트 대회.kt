package jiun.ggidid.programmerscodingtest.lv1

class Solution134240 {
    fun solution(food: IntArray): String {
        var answer: String = ""

        for(i in 1..food.lastIndex){
            repeat(food[i] / 2){
                answer += i
            }
        }

        return "${answer}0${answer.reversed()}"
    }
}

fun main() {
    val a = Solution134240()
    a.solution(intArrayOf(1, 3, 4, 6))
}