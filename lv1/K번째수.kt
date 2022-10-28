class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        
        for(arr in commands){
            answer.add(array.slice(arr[0] - 1..arr[1] - 1).sorted()[arr[2] - 1])
        }
        
        return answer.toIntArray()
    }
}