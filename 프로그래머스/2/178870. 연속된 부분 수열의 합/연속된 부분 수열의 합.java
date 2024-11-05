class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        int start = 0;
        int end = 0;
        int sum = 0;
        for(int i = 0; i<sequence.length; i++){
            sum += sequence[i];
            end = i;
            while(sum>k){
                sum -= sequence[start];
                start++;
            }
            if(sum == k&&(answer[1]-answer[0])>(end-start)){
                answer[1] = end;
                answer[0] = start;
            }
        }
        return answer;
    }
}