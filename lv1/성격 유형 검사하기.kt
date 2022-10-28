class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var choiceMap = mutableMapOf<Int, Int>()
        var type = arrayOf<Char>('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
        
        var scoreMap: MutableMap<Char, Int> = type.map{it to 0}.toMap().toMutableMap()
        
        for(i in 1..7){
            var score = if(4 - i > 0) 4 - i else (4 - i) * -1
            choiceMap.set(i, score)
        }
        
        for(i in 0..survey.size - 1){
            var score = choiceMap.getOrDefault(choices[i], 0)
            
            var result = 
            if(choices[i] <= 4) {
                survey.get(i)[0]
            }
            else{
                survey.get(i)[1]
            }
            
            var totalScore = scoreMap.getOrDefault(result, 0) + score
            
            scoreMap.set(result, totalScore)   
        }
        
        for(i in type.indices step 2){
            if(scoreMap.getOrDefault(type[i], 0) >= scoreMap.getOrDefault(type[i + 1], 0)){
                answer += type[i]
            }
            else{
                answer += type[i + 1]
            }
        }
        
        return answer
    }
}