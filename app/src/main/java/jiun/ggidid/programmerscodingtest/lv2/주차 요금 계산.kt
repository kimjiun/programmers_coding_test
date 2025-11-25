class Solution18 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var answerMap = mutableMapOf<Int, Int>()
        var inTimes = mutableMapOf<Int, String>()
        var last = "23:59"
        
        for(record in records){
            var strs = record.split(" ")
            var carNum = strs[1].toInt()
                        
            if(strs[2] == "IN"){
                inTimes.put(carNum, strs[0])
            }
            else{
                var time = calcTime(inTimes.getOrDefault(carNum, "00:00"), strs[0])
                answerMap.put(carNum, answerMap.getOrDefault(carNum, 0) + time)
               
                inTimes.remove(carNum)
            }        
        }
        
        for((k, v) in inTimes){
            var time = calcTime(v, last)
            answerMap.put(k, answerMap.getOrDefault(k, 0) + time)
        }
        
        var list = answerMap.toList().sortedBy{it.first}
        println("LIST : $list")
        
        return list.map{calcFee(fees, it.second)}.toIntArray()
    }
    
    fun calcFee(fees: IntArray, time: Int): Int{
        if(time <= fees[0]){
            return fees[1]
        }
        else{
            var leftTime = (time - fees[0]) / fees[2]
            
            if((time - fees[0]) % fees[2] > 0){
                leftTime++
            }
            
            return fees[1] + leftTime * fees[3] 
        }
    }
    
    fun calcTime(start: String, end: String): Int{
        var sTime = start.split(":")[0].toInt() * 60 + start.split(":")[1].toInt()
        var eTime = end.split(":")[0].toInt() * 60 + end.split(":")[1].toInt()
        
        return eTime - sTime
    }
}