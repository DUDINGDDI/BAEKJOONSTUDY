import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int N;
    int M;
    int[][] num;
    char[][] board;
    int lever = 0;
    int exit = 0;
    Queue<pair> q;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        board = new char[maps.length][maps[0].length()];
        pair L = new pair(0, 0);
        pair S = new pair(0, 0);
        pair E = new pair(0, 0);
        for(int i = 0; i<board.length; i++){
            char[] spl = maps[i].toCharArray();
            for(int j = 0; j<board[0].length; j++){
                board[i][j] = spl[j];
                if(board[i][j]=='L') L = new pair(i, j);
                if(board[i][j]=='S') S = new pair(i, j);
                if(board[i][j]=='E') E = new pair(i, j);
            }
        }
        q = new LinkedList<>();
        q.add(S);
        bfs(true);

        q = new LinkedList<>();
        q.add(L);
        bfs(false);
        
        if(lever==0||exit==0) answer = -1;
        else answer = lever+exit;
        
        
        return answer;
    }
    void bfs(boolean some){ //some -> true:레버, false: 문찾기
        num = new int[N][M];
        while(!q.isEmpty()){
            pair p = q.poll();
            for(int i = 0; i<4; i++){
                int rx = p.x+dx[i];
                int ry = p.y+dy[i];
                if(out(rx, ry)&&board[rx][ry]!='X'&&!(num[rx][ry]>0)){
                    int cnt = num[p.x][p.y] +1;
                    if(board[rx][ry] == 'L' && some){
                        lever = cnt;
                        return;
                    }else if(board[rx][ry] == 'E' && !some){
                        exit = cnt;
                        return;
                    }else{
                        num[rx][ry] = cnt;    
                        q.add(new pair(rx, ry));
                    }
                }
            }
        }
    }
    
    boolean out(int x, int y){
        if(x<0 || x >=N || y <0 || y>=M){
            return false;
        }
        return true;
    }
}

class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}