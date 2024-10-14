import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] st = str.split("0");
        for(int i = 0; i<st.length; i++){
            if(st[i].equals("")) continue; 
            Long a = Long.parseLong(st[i]);
            if(a<2) continue;
            boolean check = true;
            for(int j = 2; j<=Math.sqrt(a); j++){
                if(a%j==0){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}