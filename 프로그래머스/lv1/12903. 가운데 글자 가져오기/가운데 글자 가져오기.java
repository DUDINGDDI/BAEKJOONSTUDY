class Solution {
    public String solution(String s) {
        String answer = "";
        char[] ca = s.toCharArray();
        if(ca.length%2==0){
            answer += ca[ca.length/2-1];
            answer += ca[ca.length/2];
        }else{
            answer += ca[ca.length/2];
        }
        return answer;
    }
}