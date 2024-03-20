import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>(); //뽑은 인형 저장하는곳
        for(int i = 0; i<moves.length; i++){//처음부터 반복시작
            int j = 0;
            int line = moves[i]-1;
            while(j<board.length){
                if(board[j][line]!=0) { //하나씩 내려가면서 찾기
                    if(!st.empty()){    //비어있지 않을경우
                        if(st.peek()==board[j][line]){
                            st.pop();
                            answer +=2;                            
                        }else{
                            st.push(board[j][line]);
                        }
                    }else{  // 비어있을경우
                        st.push(board[j][line]);
                    }
                    board[j][line] = 0;
                    break;
                }
                j++;
            }
        }
        return answer;
    }
}