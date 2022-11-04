class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = mutableListOf<Int>()
        var nl = n.toLong()

        var startX = (left / nl).toInt()
        var startY = (left % nl).toInt()
        var endX = (right / nl).toInt()
        var endY = (right % nl).toInt()

        for(x in 0..n - 1){
            if(x < startX || endX < x){
                continue
            }

            for(y in 0..n - 1){
                if((x == startX && y < startY)
                  || (x == endX && y > endY)){
                    continue
                }

                var tmp = if(x <= y) y + 1 else x + 1
                answer.add(tmp)
            }
        }

        return answer.toIntArray()
    }
}