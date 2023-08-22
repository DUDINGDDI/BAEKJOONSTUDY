import java.util.*;

class Solution {
    public List<Integer> solution(long n) {
        String a = Long.toString(n);
        char[] arr = a.toCharArray();
        List<Integer> reverseArr = new ArrayList<>();
        for(int i = arr.length-1; i>=0; i--){
            reverseArr.add(arr[i]-48);
        }
        System.out.println(reverseArr);
        return reverseArr;
    }
}