//스택문제 ㅅㅂ
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i<numbers.length; i++){
            while(!st.isEmpty()){
                if(numbers[st.peek()]<numbers[i]){
                    int a = st.pop();
                    answer[a] = numbers[i];
                }else{
                    break;
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            answer[st.pop()] = -1;
        }
        return answer;
    }
}