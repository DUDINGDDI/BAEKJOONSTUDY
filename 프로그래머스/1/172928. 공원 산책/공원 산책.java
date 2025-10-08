class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] park, String[] routes) {
        int sx = 0, sy = 0;
        
        // 보드판 만들기 && 시작점 찾기
        char[][] board = new char[park.length][park[0].length()];
        for(int i = 0; i < board.length; i++){
            char[] line = park[i].toCharArray();
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = line[j];
                if(board[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        // 라우트 하나씩 처리
        for(int i = 0; i < routes.length; i++){
            char dirChar = routes[i].charAt(0);
            int dist = routes[i].charAt(2) - '0';
            
            int dir = 0;
            if(dirChar == 'E') dir = 2;
            else if(dirChar == 'S') dir = 1;
            else if(dirChar == 'W') dir = 3;
            else dir = 0;
            
            // 중간 경로 체크
            boolean canMove = true;
            for(int step = 1; step <= dist; step++){
                int nx = sx + dx[dir] * step;
                int ny = sy + dy[dir] * step;
                
                if(!check(nx, ny, board.length, board[0].length, board)){
                    canMove = false;
                    break;
                }
            }
            
            // 이동 가능하면 위치 업데이트
            if(canMove){
                sx += dx[dir] * dist;
                sy += dy[dir] * dist;
            }
        }
        
        return new int[]{sx, sy};
    }
    
    public boolean check(int x, int y, int rows, int cols, char[][] board){
        if(x < 0 || x >= rows || y < 0 || y >= cols) return false;
        if(board[x][y] == 'X') return false;
        return true;
    }
}