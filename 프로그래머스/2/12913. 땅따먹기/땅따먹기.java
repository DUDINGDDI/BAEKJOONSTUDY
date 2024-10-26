import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] ans = new int[land.length][4];
        
        for(int i = 0; i<4; i++){
            ans[0][i] = land[0][i];
        }
        for(int i = 1;i<land.length; i++){
            for(int j = 0; j<4; j++){
                int a = land[i][j];
                int max = 0;
                for(int k = 0; k<4; k++){
                    if(k==j) continue;
                    max = Math.max(max,ans[i-1][k]);
                }
                ans[i][j] = a+max;
            }
        }
        for(int i = 0; i<4; i++){
            answer = Math.max(answer,ans[land.length-1][i]);
        }
        return answer;
    }
}