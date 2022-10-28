class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size, {0})
        var reportedCount = mutableMapOf<String, Int>()

        var removeDup = report.distinct()
        var removeDupMap = mutableMapOf<String, MutableList<String>>()

        for(str in removeDup){
            var splited = str.split(" ")
            if(removeDupMap.containsKey(splited[0])){
                removeDupMap.get(splited[0])?.add(splited[1])
            }
            else{
                removeDupMap.set(splited[0], mutableListOf<String>(splited[1]))
            }
        }

        for(i in id_list.indices){
            reportedCount.set(id_list.get(i), 0)
        }

        for((key, list) in removeDupMap){
            for(name in list){
                var count = reportedCount.getOrDefault(name, 0)
                reportedCount.set(name, count + 1)
            }
        }

        for((name, count) in reportedCount){
            if(count >= k){
                for((key, list) in removeDupMap){
                    if(list.contains(name)){
                        answer[id_list.indexOf(key)] += 1
                    }
                }
            }
        }

        return answer
    }
}