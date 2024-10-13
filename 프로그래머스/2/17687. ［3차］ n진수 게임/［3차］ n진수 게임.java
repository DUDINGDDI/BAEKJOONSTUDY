class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder convert = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; convert.length() <= t * m; i++){
            convert.append(Integer.toString(i, n));
        }
        for(int i = p-1; ans.length()<t; i+=m){
            ans.append(convert.charAt(i));
        }
        answer = ans.toString().toUpperCase();
        return answer;
    }
}