import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int trucks = 0;
        int sum = 0;
        while(true){
            if(trucks==truck_weights.length) {
                time += bridge_length;
                break;
            }
            // System.out.println(time);
            time++;
            //트럭을 넣는다
            if(((sum+truck_weights[trucks])<=weight)){
                bridge.add(truck_weights[trucks]);
                // System.out.println(truck_weights[trucks]+"들어간다");
                sum += truck_weights[trucks];
                trucks++;
            }else{
                bridge.add(0);
                // System.out.println("0들어간다");
            }
            //트럭 뺀다
            if(bridge.size()==bridge_length){
                int a = bridge.poll();
                sum-=a;
                // if(a>0) System.out.println(a+"트럭 나왔따");
            }
            
        }
        answer = time;
        return answer;
    }
}