class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int xs = Integer.MAX_VALUE;
        int ys = Integer.MAX_VALUE;
        int xe = -1;
        int ye = -1;
        for(int i = 0; i<wallpaper.length; i++){
            if(wallpaper[i].contains("#")){
                if(ys>i) ys = i;
                if(ye<i) ye = i;
            }
            
            boolean a = false;
            boolean b = false;
            for(int j = 0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j)=='#'&&!a){
                    if(xs > j) {
                        xs = j;
                        a = true;
                    }
                }if(wallpaper[i].charAt(wallpaper[i].length()-j-1)=='#'&&!b){
                    if(xe < wallpaper[i].length()-j-1) {
                        xe = wallpaper[i].length()-j-1;
                        b = true;
                    }
                }
                if(a&&b) break;
            }
        }
        ye++;
        xe++;
        answer = new int[] {ys,xs,ye,xe};
        return answer;
    }
}