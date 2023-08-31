import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while(n!=0){
            al.add(n%3);
            n /=3;
        }
        int idx = 1;
        for(int i = al.size()-1; i>=0; i--){
            answer += al.get(i)*idx;
            idx *= 3;
        }
        return answer;
    }
}