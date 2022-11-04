class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        var list = mutableListOf<String>()
        
        for(tmp in s.split("},")){
            list.add(tmp.replace("{","").replace("}",""))
        }
        
        list.sortWith(compareBy{it.length})
        
        for(tmp1 in list){
            for(tmp2 in tmp1.split(",")){
                if(!answer.contains(tmp2.toInt()))
                    answer.add(tmp2.toInt())
            }
        }
        
        return answer.toIntArray()
    }
}