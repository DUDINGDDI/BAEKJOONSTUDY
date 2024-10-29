import java.util.*;
class Solution {
    static class pair{
        String a;
        String b;
        public pair(String a, String b){
            this.a = a;
            this.b = b;
        }
    }
    public String[] solution(String[] record) {
        String[] answer = {};
        int msgLen = 0;
        HashMap<String, String> name = new HashMap<>();
        ArrayList<pair> al = new ArrayList<>();
        for(int i = 0; i<record.length; i++){
            String[] msg = record[i].split(" ");
            if(msg[0].equals("Enter")){
                msgLen++;
                name.put(msg[1], msg[2]);
                al.add(new pair(msg[0], msg[1]));
            }else if(msg[0].equals("Leave")){
                msgLen++;
                al.add(new pair(msg[0], msg[1]));
            }else if(msg[0].equals("Change")){
                name.put(msg[1], msg[2]);
            }
        }
        answer = new String[msgLen];
        for(int i = 0; i<al.size(); i++){
            pair p = al.get(i);
            if(p.a.equals("Enter")){
                answer[i] = name.get(p.b)+"님이 들어왔습니다.";
            }else{
                answer[i] = name.get(p.b)+"님이 나갔습니다.";
            }
            
        }
        return answer;
    }
}