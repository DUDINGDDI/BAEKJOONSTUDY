class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] c = s.toCharArray();
        answer[0] = -1;
        for(int i = 1; i<s.length(); i++){
            answer[i] = -1;
            char a = c[i];
            for(int j = i-1; j>=0; j--){
                if(a==c[j]){
                    System.out.println("찾았다"+j);
                    answer[i] = i-j;
                    break;
                }
            }
        }
        
        return answer;
    }
}