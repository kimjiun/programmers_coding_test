import kotlin.math.*

class Solution14 {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        var tmp = n.toString(k).replace("0+".toRegex(), "0")
                
        for(str in tmp.split("0")){
            if(str.length == 0 || str == "1")
                continue
            
            val num = str.toLong().toDouble()
            var count = 0
            val max = sqrt(num).toLong()

            for(i in 1..max){
                if(count >= 2){
                    break
                }

                if(num.toLong() % i == 0L){
                    count++
                }
            }

            if(count == 1){
                answer++
            }
        }
        
        return answer
    }
}