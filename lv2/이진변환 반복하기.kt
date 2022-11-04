class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        
        var tmp: String = s
        
        while(tmp != "1"){
            answer[0] += 1
            answer[1] += tmp.filter{it == '0'}.count()
            
            tmp = tmp.replace("0", "").length.toString(2)
        }
        
        return answer
    }
}