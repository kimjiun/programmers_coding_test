class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val arr = arrayOf("zero", "one", "two", "three", "four",
                               "five", "six", "seven", "eight", "nine")
        
        var answerString: String = ""
        var tmpString: String = ""
                
        for(c in s){
            if(c.isDigit()){
                answerString += c
            }
            else{
                tmpString += c
            }
            
            if(!tmpString.isEmpty() && arr.contains(tmpString)){
                answerString += arr.indexOf(tmpString).toString()
                tmpString = ""
            }
            
        }
        
        println("answerString : $answerString")
        
        return answerString.toInt()
    }
}