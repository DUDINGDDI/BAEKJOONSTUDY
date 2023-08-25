class Solution {
    public long solution(int a, int b) {
        long answer = 0;    //정답
        long sum = a+b;      //처음수 끝수 더하기
        long count = 0;      //사이에 숫자 갯수 찾기

        count = Math.abs(a-b)+1;

        answer = sum*count/2;
        return answer;
    }
}