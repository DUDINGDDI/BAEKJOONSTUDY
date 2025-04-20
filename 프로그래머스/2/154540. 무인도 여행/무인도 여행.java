import java.util.*;
class Solution {
    boolean[][] vis;
    int n = 0;
    int m = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        char[][] board = new char[maps.length][maps[0].length()];
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[0].length(); j++){
                board[i][j] = maps[i].charAt(j);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        vis = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[0].length(); j++){
                if(board[i][j]!='X'&&!vis[i][j]){
                    vis[i][j] = true;
                    int res = board[i][j]-'0';
                    res += bfs(new pair(i, j), board);
                    ans.add(res);
                }
            }
        }
        Collections.sort(ans);
        if(ans.size()==0){
            answer = new int[]{-1};
        }else{
            answer = new int[ans.size()];
            for(int i = 0; i<ans.size(); i++){
                answer[i] = ans.get(i);
            }
        }
        return answer;
    }
    int bfs(pair a, char[][] bo){
        int sum = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){
            pair p = q.poll();
            for(int i = 0; i<4; i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(out(x, y)&&bo[x][y]!='X'&&!vis[x][y]){
                    sum += (bo[x][y]-'0');
                    vis[x][y] = true;
                    q.add(new pair(x, y));
                }
            }
        }
        return sum;
    }
    boolean out(int x, int y){
        if(x<0 || x>=n || y < 0||y >=m){
            return false;
        }
        return true;
    }
}
class pair{
    int x;
    int y;
    public pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}