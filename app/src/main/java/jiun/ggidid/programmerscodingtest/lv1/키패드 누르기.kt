class Solution12 {
    fun calcDistance(start: IntArray, dest: IntArray): Int{
        var x = start[0] - dest[0]
        if(x < 0) x *= -1

        var y = start[1] - dest[1]
        if(y < 0) y *= -1

        return x + y
    }
    
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        
        var keyboard = arrayOf(intArrayOf(1, 4, 7, -1), intArrayOf(2, 5, 8, 0), intArrayOf(3, 6, 9, -2))
        
        var leftHand = intArrayOf(0, 3)
        var rightHand = intArrayOf(2, 3)
        
        for(number in numbers){
            if(number in keyboard[0]){
                answer += "L"
                leftHand[0] = 0
                leftHand[1] = keyboard[0].indexOf(number)
            }
            else if(number in keyboard[2]){
                answer += "R"
                rightHand[0] = 2
                rightHand[1] = keyboard[2].indexOf(number)
            }
            else{
                var numberD = intArrayOf(1, keyboard[1].indexOf(number))
                var leftD = calcDistance(leftHand, numberD)
                var rightD = calcDistance(rightHand, numberD)
                
                if(leftD > rightD){
                    answer += "R"
                    rightHand[0] = numberD[0]
                    rightHand[1] = numberD[1]
                }
                else if(leftD < rightD){
                    answer += "L"
                    leftHand[0] = numberD[0]
                    leftHand[1] = numberD[1]
                }
                else{
                    if(hand == "right"){
                        answer += "R"
                        rightHand[0] = numberD[0]
                        rightHand[1] = numberD[1]
                    }
                    else{
                        answer += "L"
                        leftHand[0] = numberD[0]
                        leftHand[1] = numberD[1]
                    }
                }
            }
        }       
        
        return answer
    }
}