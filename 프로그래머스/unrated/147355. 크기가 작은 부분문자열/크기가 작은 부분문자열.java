class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] ct = t.toCharArray();
        char[] cp = p.toCharArray();
        for(int i = 0; i<ct.length-cp.length+1; i++){
            for(int j = 0; j<cp.length; j++){
                if(ct[i+j]>cp[j]) break;
                else if(ct[i+j]<cp[j]){
                    answer++;
                    break;
                }else{
                    if(j==cp.length-1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}