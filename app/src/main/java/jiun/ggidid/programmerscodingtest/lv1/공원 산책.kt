class Solution3 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val answer: IntArray = intArrayOf(0, 0)
        val height: Int = park.size
        val width: Int = park.firstOrNull()?.length ?: 0

        run loop@{
            park.forEachIndexed { i, s ->
                if(s.contains("S")){
                    answer[0] = i
                    answer[1] = s.indexOf("S")
                    return@loop
                }
            }
        }

        routes.forEach { route ->
            val direction = route.split(" ")[0]
            val dist = route.split(" ")[1].toIntOrNull() ?: 0

            val currentY = answer[0]
            val currentX = answer[1]

            val yRoad = park.map { it[currentX] }.joinToString("")

            when(direction){
                "E" -> {
                    if(currentX + dist < width && !park[currentY].substring(currentX, currentX + dist + 1).contains("X")){
                        answer[1] += dist
                    }
                }
                "W" -> {
                    if(currentX - dist >= 0 && !park[currentY].substring(currentX - dist, currentX).contains("X")){
                        answer[1] -= dist
                    }
                }
                "S" -> {
                    if(currentY + dist < height && !yRoad.substring(currentY, currentY + dist + 1).contains("X")){
                        answer[0] += dist
                    }
                }
                "N" -> {
                    if(currentY - dist >= 0 && !yRoad.substring(currentY - dist, currentY).contains("X")){
                        answer[0] -= dist
                    }
                }
            }
        }

        return answer
    }
}
