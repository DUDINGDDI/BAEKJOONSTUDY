import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        double a = Math.sqrt(n);
        if(a%1==0) answer = (long)((a+1)*(a+1));
        else answer = -1;
        return answer;
    }
}