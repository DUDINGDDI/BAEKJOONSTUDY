import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<prices.length; i++){
            if(st.isEmpty()){
                // System.out.println(i+"들어갔따");
                st.add(i);
                continue;
            }
            int a = prices[i];
            while(prices[st.peek()]>a){
                // System.out.println(prices[st.peek()]+"가 뒤에보다 작다"+a);
                int b = st.pop();
                answer[b] = i-b;
                if(st.isEmpty()) break;
                
            }
            st.add(i);
            // System.out.println(i+"들어갔따");
        }
        // System.out.println(st);
        while(!st.isEmpty()){
            int a = st.pop();
            // System.out.println(a);
            answer[a] = prices.length-a-1;
        }
        return answer;
    }
}