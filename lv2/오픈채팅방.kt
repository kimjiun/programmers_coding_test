class Solution {
    fun solution(records: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        var answerIndexMap = mutableMapOf<String, MutableList<Int>>()
        var idNameMap = mutableMapOf<String, String>()
        
        for(record in records){
            val strs = record.split(" ")
            val type = strs[0]
            val id = strs[1]
            
            when(type){
                "Enter" -> {
                    val name = strs[2]
                    answer.add("${name}님이 들어왔습니다.")
                    idNameMap.put(id, name)
                    var tmpList = answerIndexMap.getOrDefault(id, mutableListOf<Int>())
                    tmpList.add(answer.size - 1)
                    answerIndexMap.put(id, tmpList)
                }
                "Leave" -> {
                    val name = idNameMap.getOrDefault(id, "")
                    answer.add("${name}님이 나갔습니다.")
                    var tmpList = answerIndexMap.getOrDefault(id, mutableListOf<Int>())
                    tmpList.add(answer.size - 1)
                    answerIndexMap.put(id, tmpList)
                }
                "Change" -> {
                    val name = strs[2]
                    idNameMap.put(id, name)
                }
            }
        }
        
        for((id, indexList) in answerIndexMap){
            for(i in indexList){
                answer[i] = answer[i].replace("^.*님".toRegex(), "${idNameMap.getOrDefault(id, "")}님")
            }
        }
        
        return answer.toTypedArray()
    }
}