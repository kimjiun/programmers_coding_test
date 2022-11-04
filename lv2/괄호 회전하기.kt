class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var strQueue = s.map{it}.toMutableList<Char>()
        var dq = ArrayDeque<Char>()
        var close = charArrayOf('}', ']', ')')
        var myMap = mapOf<Char, Char>('{' to '}', '[' to ']', '(' to ')')
        
        repeat(s.length){
            var isOk = true
            
            for(c in strQueue){
                if(c in close){
                    if(dq.isEmpty() || myMap.get(dq.removeLast()) != c){
                        isOk = false
                        break
                    }
                }
                else{
                    dq.addLast(c)
                }
            }
            
            
            if(isOk && dq.isEmpty()){
                answer++
            }
            
            dq.clear()
            
            strQueue.add(strQueue[0])
            strQueue.removeAt(0)
        }
        
        return answer
    }
}