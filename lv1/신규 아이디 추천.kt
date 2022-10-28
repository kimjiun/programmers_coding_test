class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id.toLowerCase()
            .replace("[^a-z0-9-_.]".toRegex(), "")
            .replace("\\.[.]+".toRegex(), ".")
            .replace("^\\.|\\.$".toRegex(), "")
            
        if(answer.isEmpty())
            answer = "a"
        
        if(answer.length >= 16)
            answer = answer.substring(0, 15)
        
        if(answer.endsWith("."))
            answer = answer.substring(0, 14)
            
        if(answer.length <= 2){
            repeat(3 - answer.length){
                answer += answer[answer.length - 1]
            }
        }        
        
        return answer
    }
}