import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)>o2.charAt(n)){
                    return 1;
                }else if(o1.charAt(n)<o2.charAt(n)){
                    return -1;
                }else{
                    for(int i = 0; i<((o1.length()>o2.length())?o2.length():o1.length()); i++){
                        if(o1.charAt(i)>o2.charAt(i)){
                            return 1;
                        }else if(o1.charAt(i)<o2.charAt(i)){
                            return -1;
                        }
                    }
                    return 0;
                }
            }
        });
        return strings;
    }
}