import java.util.*;
class Solution {
    int min;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns ; j++){
                board[i][j] = (columns*i) + j+1;
            }
        } //보드완성
        
        for(int i = 0; i<queries.length; i++){
            min = Integer.MAX_VALUE;
            turn(board, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
            answer[i] = min;
        }
        
        return answer;
    }
    
    int[][] turn(int[][] board, int x1, int y1, int x2, int y2){
        int tmp = board[x1][y1];
        min = Math.min(tmp, min);
        for(int i = y1+1; i<=y2; i++){
            int tmp2 = board[x1][i];
            board[x1][i] = tmp;
            tmp = tmp2;
            min = Math.min(tmp, min);
        }
        
        for(int i = x1+1; i<=x2; i++){
            int tmp2 = board[i][y2];
            board[i][y2] = tmp;
            tmp = tmp2;
            min = Math.min(tmp, min);
        }
        
        for(int i = y2-1; i>=y1; i--){
            int tmp2 = board[x2][i];
            board[x2][i] = tmp;
            tmp = tmp2;
            min = Math.min(tmp, min);
        }
        
        for(int i = x2-1; i>=x1; i--){
            int tmp2 = board[i][y1];
            board[i][y1] = tmp;
            tmp = tmp2;
            min = Math.min(tmp, min);
        }
        return board;
    }
}