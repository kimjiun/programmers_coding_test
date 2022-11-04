class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var list = mutableListOf<Int>()
        var speedList = mutableListOf<Int>()
        
        (0..progresses.size - 1).map{list.add(progresses[it]); speedList.add(speeds[it])}
                
        while(list.size > 0){
            var count = 0
            
            for(i in list.indices){
                list[i] += speedList[i]
            }
            
            for(i in list.indices){
                if(list[i - count] >= 100){
                    list.removeAt(i - count)
                    speedList.removeAt(i - count)
                    count++
                }
                else{
                    break
                }
            }
            
            if(count > 0){
                answer.add(count)
            }
        }
        
        return answer.toIntArray()
    }
}