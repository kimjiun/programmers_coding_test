class Solution9 {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var tmpList = mutableListOf<Pair<Int, Double>>()
        var tmp = stages.sorted()
        
        for(i in 1..N){
            var a = tmp.count{it == i}
            var b = tmp.count{it >= i}
            var c = if(b > 0){a.toDouble() / b.toDouble()} else{0.0}            
            
            tmpList.add(Pair(i, c))
        }
        
        for(pair in tmpList.sortedByDescending{it.second}){
            answer.add(pair.first)
        }
        
        return answer.toIntArray()
    }
}