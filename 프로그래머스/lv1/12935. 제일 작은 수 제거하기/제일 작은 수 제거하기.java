class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;
        int idx = 1;
        if(arr.length==1){
            return new int[]{-1};
        }
        int[] answer = new int[size-idx];
        int del = 0;
        for(int i = 1; i<size; i++){
            if(arr[i]<arr[del]){
                del = i;
            }
        }
        idx = 0;
        for(int i = 0; i<size; i++){
            if(i!=del){
                answer[idx] = arr[i];
                idx ++;
            }
        }
        return answer;
    }
}