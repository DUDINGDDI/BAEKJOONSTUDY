import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = -1000000;
        int min = 1000000;
        for(String p : nums){
            int n = Integer.parseInt(p);
            if(max<n) max = n;
            if(min > n) min = n;
        }
        answer += min;
        answer += " ";
        answer += max;
        return answer;
    }
}