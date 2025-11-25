class Solution1 {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var tmp: Int = n
        var n3Str: String = ""
        
        n3Str = "${tmp % 3}${n3Str}"
        
        while(tmp / 3 > 0){
            tmp /= 3
            n3Str = "${tmp % 3}${n3Str}"
        }
        
        for(i in 0..n3Str.length - 1){
            var tmp2 = 1
            
            repeat(i){
                tmp2 *= 3
            }
            
            answer += n3Str[i].digitToInt() * tmp2
        }
        
        return answer
    }
}