package jiun.ggidid.programmerscodingtest.lv1

class Solution12917 {
    fun solution(s: String): String {
        return s.toCharArray()
            .sortedWith(Comparator { a, b -> b - a })
            .joinToString("")
    }
}