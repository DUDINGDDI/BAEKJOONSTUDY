import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length/2;
        
        HashSet<Integer> set = new HashSet<>();
        for(int p : nums){
        set.add(p);
        }
        
        if(num >= set.size()) answer = set.size();
        else answer = num;
        return answer;
    }
}