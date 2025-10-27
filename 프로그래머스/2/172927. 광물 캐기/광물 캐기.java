import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 곡괭이로 캘 수 있는 광물만큼만 처리
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        
        ArrayList<int[]> groups = new ArrayList<>();
        
        for(int i = 0; i<maxMinerals; i+=5){
            int dia = 0, iron = 0, stone = 0;
            
            // 5개씩 또는 남은 광물만큼
            for(int j = i; j < Math.min(i + 5, maxMinerals); j++) {
                if(minerals[j].equals("diamond")) dia++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
            }
            
            // [다이아몬드 개수, 철 개수, 돌 개수]
            groups.add(new int[]{dia, iron, stone});
        }
        
        groups.sort((a, b) -> {
            int fatigueA = a[0] * 25 + a[1] * 5 + a[2];
            int fatigueB = b[0] * 25 + b[1] * 5 + b[2];
            return fatigueB - fatigueA; // 내림차순
        });
        
        int groupIdx = 0;
        
        for(int i = 0; i<picks[0] && groupIdx < groups.size(); i++){
            int[] group = groups.get(groupIdx++);
            answer += group[0] + group[1] + group[2];
        }
        
        // 철 곡괭이 사용
        for(int i = 0; i < picks[1] && groupIdx < groups.size(); i++) {
            int[] group = groups.get(groupIdx++);
            answer += group[0] * 5 + group[1] * 1 + group[2] * 1;
        }
        
        // 돌 곡괭이 사용
        for(int i = 0; i < picks[2] && groupIdx < groups.size(); i++) {
            int[] group = groups.get(groupIdx++);
            answer += group[0] * 25 + group[1] * 5 + group[2] * 1;
        }
        
        return answer;
    }
}