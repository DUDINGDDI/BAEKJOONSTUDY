import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> al = new ArrayList<>();
        al.add((double)k);
        while(k!=1){
            if(k%2==0){
                k/=2;
                al.add((double)k);
            }else{
                k*=3;
                k++;
                al.add((double)k);
            }
        }
        double[] wide = new double[al.size()];
        for(int i = 1; i<wide.length; i++){
            wide[i] = (al.get(i-1)+al.get(i))/2;
        }
        for(int i = 0; i<ranges.length; i++){
            int a = ranges[i][0]+1;//0
            int b = al.size()+ranges[i][1];//5
            if(a<b){
                for(int j = a; j<b; j++){
                    answer[i]+=wide[j];
                }
            }else if(b<a){
                answer[i]=-1;
            }else{
                answer[i] = 0.0;
            }
        }
        return answer;
    }
}