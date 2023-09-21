import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int[] ans = new int[commands[i][1]-commands[i][0]+1];
            int j = 0;
            for(int k = 0; k<array.length; k++){
                if(k>=commands[i][0]-1&&k<commands[i][1]){
                    ans[j] = array[k];
                    j++;
                }
            }
            Arrays.sort(ans);
            answer[i] = ans[commands[i][2]-1];
        }
        return answer;
    }
}