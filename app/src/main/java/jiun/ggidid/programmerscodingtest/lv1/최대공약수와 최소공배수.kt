package jiun.ggidid.programmerscodingtest.lv1

class Solution12940 {
    fun solution(n: Int, m: Int): IntArray {
        var small = if(n < m) n else m
        var big = if(n < m) m else n
        var tmp = small

        while(big % small != 0){
            tmp = big % small
            if(tmp == 0) break
            big = small
            small = tmp
        }

        return intArrayOf(small, n * m / small)
    }
}