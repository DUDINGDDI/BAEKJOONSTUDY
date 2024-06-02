import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i = 0; i<discount.length-9; i++){
            HashMap<String, Integer> deepMap = new HashMap<>();
            for(int j = i; j<i+10; j++){
                deepMap.put(discount[j], deepMap.getOrDefault(discount[j], 0)+1);
            }
            
            boolean check = true;
            for(String key : map.keySet()){
                if(map.get(key)!=deepMap.get(key)){
                    check = false;
                    break;
                }
            }
            if(check){
                answer ++;
            }
        }
        return answer;
    }
}