class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] down = new int[players.length];
        int cnt = 1;
        for(int i = 0; i<players.length; i++){
            cnt-=down[i];
            if(players[i]>=cnt*m){
                int add = (players[i]-cnt*m)/m+1;
                cnt += add;
                if(i+k<players.length) down[i+k]+=add;
                answer += add;
            }
        }
        return answer;
    }
}