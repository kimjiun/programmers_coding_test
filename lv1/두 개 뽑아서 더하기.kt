class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var answerSet = mutableSetOf<Int>()
        
        for(i in numbers.indices){
            for(j in i+1..numbers.size - 1){
                answerSet.add(numbers[i] + numbers[j])
            }
        }
        
        answer = answerSet.toIntArray()
        
        answer.sort()
        
        return answer
    }
}