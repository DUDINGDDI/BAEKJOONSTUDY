import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        new_id = new_id.toLowerCase();
        //.=46 -=45 _=95 0=48 9=57 a=97 z=122
        //2단계
        char[] a = new_id.toCharArray();
        ArrayList<Character> ans = new ArrayList<>();
        for(char c : a){
            if(c=='.'||c=='-'||c=='_'||(c<=57&&c>=48)||(c<=122&&c>=97)){
                // answer += c;
                ans.add(c);
            }
        }
        // 3단계
        for(int i = 0; i<ans.size()-1; i++){
            if(ans.get(i)=='.'&&ans.get(i+1)=='.'){
                ans.remove(i+1);
                i--;
            }
        }
        //4단계
        if(ans.get(0)=='.') ans.remove(0);
        if(ans.size()==0) return "aaa";
        if(ans.get(ans.size()-1)=='.') ans.remove(ans.size()-1);
        //5단계
        if(ans.size()==0) return "aaa";
        //6단계
        if(ans.size()>15){
            while(ans.size()>15){
                ans.remove(ans.size()-1);
            }
        }
        if(ans.get(ans.size()-1)=='.') ans.remove(ans.size()-1);
        //7단계
        while(ans.size()<=2){
            ans.add(ans.get(ans.size()-1));
        }
        //확인로직
        for(int i = 0; i<ans.size(); i++){
           answer+=ans.get(i);
        }
        return answer;
    }
}