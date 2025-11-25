package jiun.ggidid.programmerscodingtest.lv1

class Solution12918 {
    fun solution(s: String) = (s.length == 4 || s.length == 6) && s.all{ it.isDigit() }
}