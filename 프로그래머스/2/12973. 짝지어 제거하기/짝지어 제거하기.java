import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> st = new Stack<>();
        char[] ar = s.toCharArray();
        for(char p : ar){
            if(!st.isEmpty()){
                if(p==st.peek()){
                    st.pop();
                }else{
                    st.add(p);
                }
            }else{
                st.add(p);
            }
        }
        if(st.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}