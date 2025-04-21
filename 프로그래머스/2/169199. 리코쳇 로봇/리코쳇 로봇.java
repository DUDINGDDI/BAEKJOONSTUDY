import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n, m;
    char[][] map;
    boolean[][] vis;
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        vis = new boolean[n][m];
        map = new char[board.length][board[0].length()];
        pair r = null;
        pair g = null;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length(); j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]=='R') r = new pair(i, j, 0);
                if(map[i][j]=='G') g = new pair(i, j, 0);
            }    
        }
        
        answer = bfs(r, g);
        return answer;
    }
    
    int bfs(pair r, pair g){
        Queue<pair> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            pair in = q.poll();
            
            if (in.x == g.x && in.y == g.y) {
                return in.cnt;
            }
            
            for(int i = 0; i<4; i++){
                int nx = in.x;
                int ny = in.y;
                while(out(nx, ny)&&map[nx][ny]!='D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                if (vis[nx][ny] || (in.x == nx && in.y == ny)) continue;
                
                vis[nx][ny] = true;
                q.add(new pair(nx, ny, in.cnt + 1));
            }
        }
        return -1;
    }
    
    boolean out(int x, int y){
        if(x<0 || x>=n|| y<0 || y>=m){
            return false;
        }
        return true;
    }
}
class pair{
    int x;
    int y;
    int cnt;
    public pair(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}