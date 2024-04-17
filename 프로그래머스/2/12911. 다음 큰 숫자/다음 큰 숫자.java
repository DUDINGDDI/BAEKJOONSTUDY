import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                cnt++;
            }
        }
        while(true){
            n++;
            String st = Integer.toBinaryString(n);
            int tmp = 0;
            for(int i = 0; i<st.length(); i++){
                if(st.charAt(i)=='1'){
                tmp++;
                }
            }
            if(tmp==cnt){
                answer = n;
                break;
            }
        }
        return answer;
    }
}