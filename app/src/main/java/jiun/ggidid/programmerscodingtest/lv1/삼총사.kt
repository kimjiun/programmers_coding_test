package jiun.ggidid.programmerscodingtest.lv1

class Solution131705 {
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        for(i in 0..number.size - 3){
            for(j in i+1.. number.size - 2){
                for(k in j+1.. number.size - 1){
                    if(number[i] + number[j] + number[k] == 0) answer++
                }
            }
        }

        return answer
    }
}

fun main() {
    val a = Solution131705()
    a.solution(intArrayOf(-2, 3, 0, 2, -5))
//    a.solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3))
}