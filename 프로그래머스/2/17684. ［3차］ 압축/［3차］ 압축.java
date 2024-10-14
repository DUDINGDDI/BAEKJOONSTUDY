import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();  //A65, Z90
        for(int i = 1; i<=26; i++){
            String a = String.valueOf((char)(i+64));
            hm.put(a, i);
        }
        String[] st = msg.split("");
        for(int i = 0; i<st.length; i++){
            String str = "";
            for(int j = 0; j+i<st.length; j++){
                str += st[i+j];
                if(hm.containsKey(str)){
                    if((j+i)==(st.length-1)) {
                        i+=j;
                        break;
                    }
                    continue;
                }else{
                    hm.put(str, hm.size()+1);
                    str = str.substring(0, str.length()-1);
                    i+=(j-1);
                    break;
                }
            }
            answer.add(hm.get(str));
        }
        return answer;
    }
}