class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int p : arr){
            answer += p;
        }
        answer /= arr.length;
        return answer;
    }
}