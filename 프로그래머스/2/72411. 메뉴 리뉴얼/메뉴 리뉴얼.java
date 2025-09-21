import java.util.*;
class Solution {
    static ArrayList<String> ans = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        char[][] sortedOrders = new char[orders.length][];
        for(int i = 0; i<orders.length; i++){
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            sortedOrders[i] = ch;
        }
        
        for(int r : course){
            Map<String, Integer> freq = new HashMap<>();
            int maxCount = 0;
            
            for(char[] order : sortedOrders){
                if(order.length<r) continue;
                dfs(order, 0, r, new StringBuilder(), freq);
            }
            
            for(int cnt : freq.values()){
                if(cnt>maxCount) maxCount = cnt;
            }
            if(maxCount<2) continue;
            
            for(Map.Entry<String, Integer> e : freq.entrySet()){
                if(e.getValue() == maxCount) result.add(e.getKey());
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    private void dfs(char[] order, int start, int r, StringBuilder pick, Map<String, Integer> freq){
        if(r==0){
            String key = pick.toString();
            freq.put(key, freq.getOrDefault(key, 0)+1);
            return;
        }
        for(int i = start; i<=order.length-r; i++){
            pick.append(order[i]);
            dfs(order, i+1, r-1, pick, freq);
            pick.deleteCharAt(pick.length()-1);
        }
    }
    
}