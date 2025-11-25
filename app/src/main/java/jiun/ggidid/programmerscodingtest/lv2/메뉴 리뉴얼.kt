class Solution22 {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()
        var countMap = mutableMapOf<String, Int>()
        
        for(order in orders){
            var tmpSet = mutableSetOf<String>()
            
            for(menu in order.toList().sorted()){
                var tmpSet2 = mutableSetOf<String>()
                tmpSet2.addAll(tmpSet)
                
                tmpSet.add("$menu")
                
                for(tmpStr in tmpSet2){
                    val item = "${tmpStr}${menu}"
                    tmpSet.add(item)
                }
            }
            
            for(candi in tmpSet){
                if(course.contains(candi.length)){
                    var score = countMap.getOrDefault(candi, 0)
                    countMap.put(candi, score + 1)
                }
            }
        }
        
        for(count in course){
            var tmpList = countMap.toList().filter{it.first.length == count}.filter{it.second > 1}
            
            if(tmpList.size < 1){
                continue
            }
            
            var maxCount = tmpList.map{it.second}.sorted().last()
            var maxList = tmpList.filter{it.second == maxCount}.map{it.first}
            
            answer.addAll(maxList)
        }
        
        return answer.sorted().toTypedArray()
    }
}