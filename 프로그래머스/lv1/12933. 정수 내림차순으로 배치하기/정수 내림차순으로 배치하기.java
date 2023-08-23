import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> arr = new ArrayList<>();
        while(n!=0){
            arr.add(n%10);
            n/=10;
        }
        Collections.sort(arr);
        long idx = 1;
        for(long p : arr){
            answer += p*idx;
            idx *=10;
        }
        return answer;
    }
}