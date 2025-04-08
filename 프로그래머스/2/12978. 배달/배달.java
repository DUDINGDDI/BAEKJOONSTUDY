import java.util.*;
class Solution {
    class pair{
        int to;
        int sum;
        public pair(int to, int sum){
            this.to = to;
            this.sum = sum;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[] res = new int[N+1];
        int[][] path = new int[N+1][N+1];
        for(int i = 0; i<=N; i++){
            res[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i<road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int z = road[i][2];
            if(path[x][y]!=0){
                z = Math.min(z, path[x][y]);
            }
            path[x][y] = z;
            path[y][x] = z;
        }
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i<=N; i++){
            if(path[1][i]!=0){
                res[i] = path[1][i];
                q.add(new pair(i, path[1][i]));
            }
        }
        while(!q.isEmpty()){
            pair p = q.poll();
            for(int i = 1; i<=N; i++){
                if(path[p.to][i]!=0){
                    int a = p.sum+path[p.to][i];
                    if(a<=res[i]) {
                        res[i] = a;
                        q.add(new pair(i, a));
                    }
                }
            }
        }
        for(int i = 2; i<=N; i++){
            if(res[i]<=K) answer++;
        }
        return answer;
    }
}