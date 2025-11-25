class Solution17 {
    fun solution(s: String): String {
        val strList = s.split(" ").map { it.toInt() }
        val max1 = strList.max()
        val min1 = strList.min()
        
        var intArr = s.split(" ")
            .map{ it.toInt() }
            .toIntArray()
            
        var max = intArr[0]
        var min = intArr[0]
        
        for(i in intArr){
            if(max < i){
                max = i
            }
            
            if(min > i){
                min = i
            }
        }
        
        return "$min $max"
    }
}