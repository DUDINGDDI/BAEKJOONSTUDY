class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1; i<=n/2; i++){
            // System.out.println("i"+i);
            int sum = 0;
            int plus = i;
            while(sum <n){
                sum += plus;
                plus++;
                // System.out.println(sum);
            }
            if(sum == n){
                // System.out.println(i+"성공");
                answer ++;
            }
        }
        return answer;
    }
}