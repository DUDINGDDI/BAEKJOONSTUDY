class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0){
            int ans = storey%10;
            storey/=10;
            
            if(ans==5){
                if(storey%10>=5){
                    answer += (10-ans);
                    storey++;
                }else{
                    answer += ans;
                }
            }else if(ans > 5){
                answer += (10-ans);
                storey++;
            }else{
                answer += ans;
            }
        }
        return answer;
    }
}