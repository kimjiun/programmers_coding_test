package jiun.ggidid.programmerscodingtest.lv1

class Solution142086 {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        val indexMap = hashMapOf<Char, Int>()

        answer = s.mapIndexed { index, ch ->
            val lastIndex: Int? = indexMap[ch]
            indexMap[ch] = index
            if(lastIndex == null){
                -1
            }
            else{
                index - lastIndex
            }
        }.toIntArray()

        println(answer.joinToString())

        return answer
    }
}

fun main() {
    val a = Solution142086()
    a.solution("banana")
}