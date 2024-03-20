class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {-1, 0, 0, 1};
        String s = board[h][w];
        for(int i = 0; i<4; i++){
            int hCheck = h+dh[i];
            int wCheck = w+dw[i];
            if(hCheck >=0&&hCheck <board.length&&wCheck >=0&&wCheck <board.length&&s.equals(board[hCheck][wCheck])){
                answer ++;
            }
            
        }
        return answer;
    }
}