import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer, Long> hm = new HashMap<>();
        for(int i = 0; i<weights.length; i++){
            hm.put(weights[i], hm.getOrDefault(weights[i], (long)0)+1);
        }
        Set<Integer> set = hm.keySet();
        
        for(Integer a : set){
            if(hm.get(a)>1){
                answer+=((hm.get(a)*(hm.get(a)-1))/2);
            }
            for(Integer b : set){
                if(a==b) continue;
                if(a*3==b*2||a*2==b||a*4==b*3){
                    // System.out.println(a+" "+b);
                    answer +=(hm.get(a)*hm.get(b));
                }
            }
        }
        // System.out.println(Arrays.toString(weights));
        return answer;
    }
}