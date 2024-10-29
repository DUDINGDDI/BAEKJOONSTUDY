import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();
        for(int i = 1; i<=order.length; i++){
            main.add(i);
        }
        int num = 0;
        while(!main.isEmpty()||!sub.isEmpty()){
            //맨위에 있으면 빼내기
            if(!main.isEmpty()&&main.peek()==order[num]){
                main.poll();
                num++;
                answer ++;
                continue;
            }
            else if(!sub.isEmpty()&&sub.peek()==order[num]){
                sub.pop();
                num++;
                answer ++;
                continue;
            }
            //둘다 맨위에 없을때
            if(main.isEmpty()&&!sub.isEmpty()&&sub.peek()!=order[num]) break;
            if(!main.isEmpty()){
                int out = main.poll();
                sub.add(out);
            }
        }
        return answer;
    }
}