class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int y = x;
        while(y!=0){
            sum += y%10;
            y/=10;
        }
        boolean answer = true;
        if(x%sum!=0) answer = false;
        return answer;
    }
}