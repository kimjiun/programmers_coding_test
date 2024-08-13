class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val giftMap = arrayListOf<Pair<String, String>>()
        val scoreMap = hashMapOf<String, Int>()
        val answerMap = hashMapOf<String, Int>()

        friends.forEachIndexed { index, s ->
            for(j in index + 1 .. friends.size - 1) {
                giftMap.add(s to friends[j])
            }

            scoreMap[s] = 0
            answerMap[s] = 0
        }

        gifts.forEach {
            val giver = it.split(" ")[0]
            val receiver = it.split(" ")[1]

            scoreMap[giver] = scoreMap.getOrDefault(giver, 0) + 1
            scoreMap[receiver] = scoreMap.getOrDefault(receiver, 0) - 1
        }

        giftMap.forEach { pair ->
            val firstGive = gifts.filter { it == "${pair.first} ${pair.second}"}.size
            val secondGive = gifts.filter { it == "${pair.second} ${pair.first}"}.size


            if(firstGive < secondGive){
                answerMap[pair.second] = answerMap.getOrDefault(pair.second, 0) + 1
            }
            else if (firstGive == secondGive){
                val firstScore = scoreMap.getOrDefault(pair.first, 0)
                val secondScore = scoreMap.getOrDefault(pair.second, 0)

                if(firstScore < secondScore){
                    answerMap[pair.second] = answerMap.getOrDefault(pair.second, 0) + 1
                }
                else if(firstScore > secondScore){
                    answerMap[pair.first] = answerMap.getOrDefault(pair.first, 0) + 1
                }
            }
            else{
                answerMap[pair.first] = answerMap.getOrDefault(pair.first, 0) + 1
            }
        }

        return answerMap.values.maxOrNull() ?: 0
    }
}
