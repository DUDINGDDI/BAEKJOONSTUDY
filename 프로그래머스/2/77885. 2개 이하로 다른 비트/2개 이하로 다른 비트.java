class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i];
            answer[i]++; // x보다 큰수로 만든다.
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }
}