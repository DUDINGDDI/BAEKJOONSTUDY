import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i] == 1||numbers[i] == 4||numbers[i] == 7){
                left = numbers[i];
                answer += "L";
            }else if(numbers[i] == 3||numbers[i] == 6||numbers[i] == 9){
                right = numbers[i];
                answer += "R";
            }else{
                if(numbers[i] == 0) numbers[i] = 11;
                int n = numbers[i];
                int lh = Math.abs(left-n)/3+Math.abs(left-n)%3;
                int rh = Math.abs(right-n)/3+Math.abs(right-n)%3;
                if(lh>rh) {
                    right = n;
                    answer += "R";
                }
                else if(lh<rh) {
                    left = n;
                    answer += "L";
                }
                else{
                    if(hand.equals("right")) {
                        right = n;
                        answer += "R";
                    }
                    else {
                        left = n;
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }
}