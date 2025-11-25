class Solution11 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var mBoard = board
        var boxArray = mutableListOf<Int>()
        
        for(pick in moves){
            for(row in mBoard){
                if(row[pick - 1] != 0){
                    boxArray.add(row[pick - 1])
                    row[pick - 1] = 0
                    
                    if(boxArray.size >= 2 && 
                            boxArray.get(boxArray.size - 1) == boxArray.get(boxArray.size - 2)){
                        answer += 2
                        boxArray.removeLast()
                        boxArray.removeLast()
                    }
                    
                    break
                }
            }
        }
        
        return answer
    }
}