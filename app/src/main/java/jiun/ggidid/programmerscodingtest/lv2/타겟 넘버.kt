class Solution16 {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        var list = mutableListOf<Int>()
        
        list.add(0)
        
        for(number in numbers){
            for(i in list.indices){
                list.add(list[i] - number)
                list[i] += number
            }
        }        
        
        return list.count{it == target}
    }
}