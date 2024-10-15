class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String dirs) {
        int answer = 0;
        //순서 나누기
        String[] splitStr = dirs.split("");
        boolean[][][] vis = new boolean[12][12][4];
        int x = 5;
        int y = 5;
        for(int i = 0; i<splitStr.length; i++){
            System.out.println(i+"번");
            int dir = -1;
            switch(splitStr[i]){
                case "U":
                    dir = 0;
                    break;
                case "R":
                    dir = 1;
                    break;
                case "D":
                    dir = 2;
                    break;
                case "L":
                    dir = 3;
                    break;
            }
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            int dir1 = (dir+2)%4;
            if(!out(nx, ny)) continue;
            System.out.println(vis[x][y][dir]);
            if(!vis[x][y][dir]) {
                System.out.println((x-5)+" "+(y-5));
                answer++;
            }
            vis[x][y][dir] = true;
            vis[nx][ny][dir1] = true;
            x = nx;
            y = ny;
        }
        return answer;
    }
    
    static boolean out(int x, int y){
        if(x<0||x>10||y<0||y>10) return false;
        return true;
    }
}