class Solution10 {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var garo = 0
        var sero = 0
        
        for(arr in sizes){
            arr.sort()
            
            if(garo < arr[0])
                garo = arr[0]
            
            if(sero < arr[1])
                sero = arr[1]
        }
        
        return garo * sero
    }
}