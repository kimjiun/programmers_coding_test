package jiun.ggidid.programmerscodingtest.lv1

import kotlin.math.max

class Solution42840 {
    fun solution(answers: IntArray): IntArray {
        val num1 = intArrayOf(1, 2, 3, 4, 5)
        val num2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val num3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val countMap = hashMapOf<Int, Int>()
        var count1 = 0
        var count2 = 0
        var count3 = 0

        for(i in 0..answers.lastIndex){
            val answer = answers[i]
            if(answer == num1[i % num1.size]) count1++
            if(answer == num2[i % num2.size]) count2++
            if(answer == num3[i % num3.size]) count3++
        }

        countMap[1] = count1
        countMap[2] = count2
        countMap[3] = count3

        val countArray = intArrayOf(count1, count2, count3)
        val max = max(max(count1, count2), count3)

        println(countArray)

        return countMap.filter {
            it.value == max
        }.keys.toIntArray()
    }
}

fun main() {
    val a = Solution42840()
    a.solution(intArrayOf(1, 2, 3, 4, 6))
}