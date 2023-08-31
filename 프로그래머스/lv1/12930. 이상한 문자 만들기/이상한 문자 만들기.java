class Solution {
    public String solution(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        int idx = 0;
        for(char p : ch){
            if(p ==' '){
                idx = 0;
                answer += p;
                continue;
            }
            if(idx == 0 || idx%2==0){
                if(p<=122&&p>=97){
                    answer += (char)(p-32);
                }else{
                    answer += p;
                }
                idx++;
            }else{
                if(p<=90&&p>=65){
                    answer += (char)(p+32);
                }else{
                    answer += p;
                }
                idx++;
            }
        }
        return answer;
    }
}