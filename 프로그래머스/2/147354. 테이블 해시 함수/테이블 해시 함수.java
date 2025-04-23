import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        col--;
        row_begin--;
        int column = col;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[column]==o2[column]) return o2[0] - o1[0];
            return o1[column] - o2[column];
        });
        
        for(int i = row_begin; i<row_end; i++){
            
            int tot = 0;
            for(int num : data[i]){
                int ans = num%(i+1);
                tot+=ans;
            }
            answer = (answer ^ tot);
        }
        
        return answer;
    }
}