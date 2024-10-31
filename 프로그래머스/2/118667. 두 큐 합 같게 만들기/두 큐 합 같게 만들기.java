import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        //큐에 넣기
        for(int i = 0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        long sum = sum1+sum2;
        if(sum%2!=0) return -1;
        while(true){
            if(answer>(queue1.length+queue2.length)*2) return -1;
            if(sum1==sum/2){
                break;
            }else if(sum1>sum/2){
                int a = q1.poll();
                q2.add(a);
                sum1 -= a;
                sum2 += a;
                answer ++;
            }else{
                int a = q2.poll();
                q1.add(a);
                sum1 += a;
                sum2 -= a;
                answer ++;
            }
        }
        return answer;
    }
}