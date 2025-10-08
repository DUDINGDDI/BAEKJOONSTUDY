class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i<schedules.length; i++){
            int today = startday;
            boolean check = true;
            for(int j = 0; j< timelogs[i].length; today++, j++){
                // System.out.println(j+" "+today);
                today%=7;
                if(today==6||today==0) continue;
                check = inTime(schedules[i], timelogs[i][j]);
                // System.out.println(check);
                if(!check)break;
            }
            if(check) answer ++;
        }
        return answer;
    }
    public boolean inTime (int a, int b){
        int limit = a+10;
        if(limit%100>=60){
            limit += 100;
            limit -= 60;
        }
        // System.out.print(limit+ " ");
        // System.out.println(b);
        if(limit >= b) return true;
        return false;
    }
} 