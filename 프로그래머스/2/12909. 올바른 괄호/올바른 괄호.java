import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] str = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(char p : str){
            if(p=='('){
                st.add(p);
            }else{
                if(st.isEmpty()) return false;
                else if(st.peek()=='(') st.pop();
            }
        }
        if(!st.isEmpty()) answer = false;
        return answer;
    }
}