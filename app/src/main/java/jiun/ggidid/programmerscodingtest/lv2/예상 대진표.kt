class Solution21 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var tmpA = a
        var tmpB = b
        var result = intArrayOf(1, -1)
        
        while(true){
            answer++
            
            if(result.contains(tmpA - tmpB)
              && tmpA / 2 != tmpB / 2){
                break
            }
            
            tmpA = (tmpA + 1) / 2
            tmpB = (tmpB + 1) / 2
        }

        return answer
    }
}