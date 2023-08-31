import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        int[] answer = {};
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            if(!st.empty()&&st.peek()==arr[i]){
                continue;
            }
            st.push(arr[i]);
        }
        return st;
    }
}