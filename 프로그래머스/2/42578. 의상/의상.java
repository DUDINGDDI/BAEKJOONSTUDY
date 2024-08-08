import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        //HashMap에 옷의 갯수를 저장한다
        for(int i = 0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        //조합을 통해 갯수 구하기
        for(String p: map.keySet()){
            answer *= (map.get(p)+1);//안입는 경우 고려
        }
        
        answer --;//아무것도 안입은 경우 
        
        
        return answer;
    }
}