class Solution {
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] tri = new int[n][n];
        int dir = 0;
        int x = -1;
        int y = 0;
        int num = 1;
        for(int i = n; i>0; i--){
            for(int j = 0; j<i; j++){
                x += dx[dir];
                y += dy[dir];
                tri[x][y] = num;
                num++;
            }
            dir++;
            dir%=3;
        }
        num = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(tri[i][j]==0) break;
                answer[num] = tri[i][j];
                num++;
            }
        }
        return answer;
    }
}