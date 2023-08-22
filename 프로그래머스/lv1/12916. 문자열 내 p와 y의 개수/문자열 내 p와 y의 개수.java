class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] str = s.toCharArray();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int p = 0;
        int y = 0;
        for(char each : str){
            if(each == 'p' || each =='P'){
                p++;
            }else if(each == 'y'|| each =='Y'){
                y++;
            }
        }
        if(p!=y) answer = false;

        return answer;
    }
}