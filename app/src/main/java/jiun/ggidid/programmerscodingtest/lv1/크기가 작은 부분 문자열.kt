package jiun.ggidid.programmerscodingtest.lv1

class Solution147355 {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        val pNum = p.toLong()

        for(i in 0..(t.length - p.length )){
            val splitNum = t.substring(i, i + p.length).toLong()
            if(splitNum <= pNum) answer++
        }

        return answer
    }
}

fun main() {
    val a = Solution147355()
    a.solution("3141592", "271")
}