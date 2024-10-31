class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        boolean[][] vis = new boolean[arr.length][arr[0].length];
        while(size>0){
            
            for(int i = 0; i<arr.length; i+=size){
                for(int j = 0; j<arr.length; j+=size){
                    //일단 이전에 박스를 만든적 있는지 확인
                    if(vis[i][j]) continue;
                    //확인하기!
                    int stan = arr[i][j];
                    boolean check = true;
                    for(int k = i; k<i+size; k++){
                        for(int l = j; l<j+size; l++){
                            if(arr[k][l]!=stan) {
                                check = false;
                                break;
                            }
                        }
                        if(!check) break;
                    }
                    //박스 완성시
                    if(check){
                        answer[arr[i][j]]++;
                        for(int k = i; k<i+size; k++){
                            for(int l = j; l<j+size; l++){
                                vis[k][l] = true;
                            }
                        }
                    }
                }
            }
            size/=2;
        }
        return answer;
    }
}