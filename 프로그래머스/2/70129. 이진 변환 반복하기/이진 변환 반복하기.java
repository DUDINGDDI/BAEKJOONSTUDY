class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            char[] ch = s.toCharArray();
            int cnt = 0;
            for(char p : ch){
                if(p=='0'){
                    answer[1]++;
                }else{
                    cnt++;
                }
            }
            s = Integer.toBinaryString(cnt);
            answer[0]++;
        }
        return answer;
    }
}