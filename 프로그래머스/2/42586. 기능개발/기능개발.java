import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> st = new LinkedList<>();
        for(int p : progresses){
            st.add(p);
        }
        int day = 0;
        int out = 0;
        while(true){
            day++;
            int a = 0;
            while(!st.isEmpty()){
                if((st.peek()+(day*speeds[out]))>=100){
                    out++;
                    st.poll();
                    a++;
                }else{
                    break;
                }
            }
            if(a>0) answer.add(a);
            if(st.isEmpty()) break;
        }
        return answer;
    }
}