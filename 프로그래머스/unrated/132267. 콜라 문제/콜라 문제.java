class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int rest = 0;
        while(n >= a){
            rest = n%a;
            n/=a;
            n*=b;
            answer += n;
            n+= rest;
            rest = 0;
        }
        return answer;
    }
}