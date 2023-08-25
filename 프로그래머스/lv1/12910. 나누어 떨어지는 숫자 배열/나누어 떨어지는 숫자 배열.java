import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> al = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                al.add(arr[i]);
            }
        }
        if(al.size()==0){
            al.add(-1);
        }
        return al;
    }
}