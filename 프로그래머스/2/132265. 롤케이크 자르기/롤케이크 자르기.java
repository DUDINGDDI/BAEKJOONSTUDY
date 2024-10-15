import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        //왼쪽 담당
        int[] left = new int[topping.length];
        HashSet<Integer> leftHs = new HashSet<>();
        for(int i =0 ; i<topping.length; i++){
            leftHs.add(topping[i]);
            left[i] = leftHs.size();
        }
        //오른쪽 담당
        int[] right = new int[topping.length];
        HashSet<Integer> rightHs = new HashSet<>();
        for(int i =topping.length-1 ; i>=0; i--){
            rightHs.add(topping[i]);
            right[i] = rightHs.size();
        }
        //확인하기
        for(int i = 0; i<topping.length-1; i++){
            if(left[i]==right[i+1]) answer++;
        }
        return answer;
    }
}