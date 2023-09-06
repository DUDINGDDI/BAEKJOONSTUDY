class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] ar1 = new int[n];
        int[] ar2 = new int[n];
        for(int i = 0; i<n; i++){
            answer[i] = "";
            for(int j = n-1; j>=0; j--){
                ar1[j] = arr1[i]%2;
                arr1[i]/=2;
                ar2[j] = arr2[i]%2;
                arr2[i]/=2;
            }
            for(int j = 0; j<n; j++){
                if(ar1[j] == 1 || ar2[j] ==1){
                    answer[i] += "#";
                }else{
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
}