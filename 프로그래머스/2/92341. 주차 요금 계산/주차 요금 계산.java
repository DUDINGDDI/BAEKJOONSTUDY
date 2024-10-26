import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i<records.length; i++){
            String[] st = records[i].split(" ");
            int time = Integer.parseInt(st[0].substring(0,2))*60+Integer.parseInt(st[0].substring(3,5));
            int num = Integer.parseInt(st[1]);
            // System.out.println(time);
            if(st[2].equals("IN")){
                hm.put(num, time);
                if(!al.contains(num)) al.add(num);
            }else{
                int diff = time - hm.get(num);
                hm.remove(num);
                res.put(num, res.getOrDefault(num, 0)+diff);
            }
        }
        Collections.sort(al);
        answer = new int[al.size()];
        int end = 23*60+59;
        for(int i = 0; i<al.size(); i++){
            int a = al.get(i);
            int time = 0;
            if(hm.get(a)!=null){
                time = end-hm.get(a);
            }
            int useT = res.getOrDefault(a, 0)+time;
            if(useT<=fees[0]) answer[i] = fees[1];
            else{
                if((useT-fees[0])%fees[2]==0)
                    answer[i] = fees[1]+((useT-fees[0])/fees[2])*fees[3];
                else{
                    answer[i] = fees[1]+((useT-fees[0])/fees[2]+1)*fees[3];
                }
            }
        }
        return answer;
    }
}