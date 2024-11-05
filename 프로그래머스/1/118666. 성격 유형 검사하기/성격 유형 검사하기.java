import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("RT", 0);
        hm.put("CF", 0);
        hm.put("JM", 0);
        hm.put("AN", 0);
        for(int i = 0; i<choices.length; i++){
            char[] a = survey[i].toCharArray();
            Arrays.sort(a);
            String str = new String(a);
            if(survey[i].equals(str)){
                hm.put(str, hm.get(str)+4-choices[i]);
            }else{
                hm.put(str, hm.get(str)+choices[i]-4);
            }
        }
        Set<String> keySet = hm.keySet();
        StringBuilder sb = new StringBuilder();
        for(String s : keySet){
            int num = hm.get(s);
            if(num>=0){
                sb.append(s.charAt(0));
            }else if(num<0){
                sb.append(s.charAt(1));
            }
        }
        answer = sb.toString();
        return answer;
    }
}