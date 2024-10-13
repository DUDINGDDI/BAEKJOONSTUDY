import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();  //소문자로 다 만들고
        str2 = str2.toLowerCase();
        //문자 집합 배열
        ArrayList<String> spl1 = new ArrayList<>();
        ArrayList<String> spl2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        char[] cl1 = str1.toCharArray();
        int a = 'z';//97 122
        for(int i = 0; i<str1.length()-1; i++){
            if(cl1[i]<97||cl1[i]>122||cl1[i+1]<97||cl1[i+1]>122){
                continue;
            }
            String str = (cl1[i]+""+cl1[i+1]);
            spl1.add(str);
        }
        char[] cl2 = str2.toCharArray();        
        for(int i = 0; i<str2.length()-1; i++){
            if(cl2[i]<97||cl2[i]>122||cl2[i+1]<97||cl2[i+1]>122){
                continue;
            }
            String str = (cl2[i]+""+cl2[i+1]);
            spl2.add(str);
        }
        System.out.println(spl1);
        //합집합 찾기
        for(String s : spl1){
            if(spl2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }
      
        for(String s : spl2){
            union.add(s);
        }
      
        double jakard = 0;
        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }
}