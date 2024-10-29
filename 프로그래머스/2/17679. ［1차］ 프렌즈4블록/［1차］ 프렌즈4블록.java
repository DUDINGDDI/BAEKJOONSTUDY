import java.util.*;
class Solution {
    static boolean check = false;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        //1단 보드를 쪼개
        String[][] boards = new String[m][n];
        for(int i = 0; i<m; i++){
            String[] spl = board[i].split("");
            for(int j = 0; j<n; j++){
                boards[i][j] = spl[j];
            }
        }
        while(true){
            //돌면서 찾아보자잉
            boolean[][] vis = new boolean[m][n];//true갯수 나중에 구할겨(날라간친구)
            check = false;  //다시 돌지 확인할껴
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n-1; j++){
                    if(!boards[i][j].equals("BL")) findSq(i, j, boards, vis);
                }
            }
            //여기서 짤라줄꺼임
            if(!check) break;

            //다 돌고 visit했다
            //visit인애들 지우자
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(vis[i][j]) {
                        boards[i][j] = "BL";
                        answer++;
                    }
                }
            }
        
            //B치우고 밑으로 내리자
            down(boards, n, m);
        }
        return answer;
    }
    
    static void findSq(int a, int b, String[][] boards, boolean[][] vis){
        String str = boards[a][b];
        if(boards[a+1][b].equals(str)&&boards[a][b+1].equals(str)&&boards[a+1][b+1].equals(str)){
            vis[a][b]=true;
            vis[a+1][b]=true;
            vis[a][b+1]=true;
            vis[a+1][b+1]=true;
            check = true;
        }
    }
    
    static void down(String[][] boards,int n, int m){
        for(int i = 0; i<n; i++){
            Queue<String> q = new LinkedList<>();
            for(int j = m-1; j>=0; j--){
                q.add(boards[j][i]);
            }
            int j = m-1;
            int k = 0;
            while(!q.isEmpty()){
                if(q.peek()!="BL") {
                    boards[j][i] = q.poll();
                    j--;
                }else{
                    boards[k][i] = q.poll();
                    k++;
                }
            }
        }
    }
}