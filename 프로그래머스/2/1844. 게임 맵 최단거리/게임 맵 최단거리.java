import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int m;
    public int solution(int[][] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        boolean[][] vis = new boolean[n][m];
        Pair pair = new Pair(0, 0);
        vis[0][0]= true;
        maps[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i<4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(check(x, y)&&!vis[x][y]&&(maps[x][y]!=0)){
                    vis[x][y] = true;
                    maps[x][y] = maps[p.x][p.y]+1;
                    q.add(new Pair(x,y));
                }
            }
        }
        if(maps[n-1][m-1] != 0) answer = maps[n-1][m-1];
        if(!vis[n-1][m-1]) answer = -1;
        return answer;
    }
    
    public boolean check(int x, int y){
        if(x<0||x>=n||y<0||y>=m) return false;
        return true;
    }
}