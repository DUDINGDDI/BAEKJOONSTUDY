import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = -1;
        int knight = n;
        int guard = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int round = 1;
        for(int attack : enemy){
            pq.add(attack);
            knight -= attack;
            
            if(knight < 0){
                while(!pq.isEmpty()){
                    if(guard == 0){
                        break;
                    }
                    
                    knight += pq.poll();
                    guard--;
                    
                    if(knight >= 0){
                        break;
                    }
                }
            }
            if(knight < 0){
                return round -1;
            }
            round ++;
        }
        return enemy.length;
    }
}