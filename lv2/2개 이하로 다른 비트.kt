class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer = mutableListOf<Long>()
        
        for(number in numbers){
            if(number % 2L == 0L){
                answer.add(number + 1L)
            }
            else{
                var bit = number.toString(2)
                var index = bit.lastIndexOf('0')
                
                if(index < 0){
                    bit = "0${bit}"
                    index = 0
                }
                
                bit = "1${bit.substring(index + 2).replace("1", "0")}"
                
                answer.add(number + bit.toLong(2))
            }
        }
        
        return answer.toLongArray()
    }
}