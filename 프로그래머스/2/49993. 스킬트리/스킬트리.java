class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i<skill_trees.length; i++){
            //리플레이스 하기
            String str = skill_trees[i].replaceAll("[^" + skill + "]", "");
            
            String s = skill.substring(0,str.length());
            if(str.equals(s)){
                answer ++;
            }
        }
        return answer;
    }
}