import java.util.*;
class Solution {
    public int solution(String s) {
        char[] str = s.toCharArray();
        int answer = 0;
        int pm = 0;
        
        if(str[0]=='-'){
            pm=-1;
        }else if(str[0]=='+'){
            pm = 1;
        }
        int ten = 1;
        for(int i =str.length-1 ; i>=Math.abs(pm); i--){
            answer += (str[i]-48)*ten;
            ten *= 10;
        }
        if(pm==-1) answer *=pm;
        return answer;
    }
}