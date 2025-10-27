import java.util.*;
class Solution {
    class Pair {
    Integer first;
    Integer second;
    
    // 생성자
    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> musicSum = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
            musicSum.put(genres[i], musicSum.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<String> listKeySet = new ArrayList<>(musicSum.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (musicSum.get(value2).compareTo(musicSum.get(value1))));
		for(String key : listKeySet) {
            ArrayList<Pair> arr = new ArrayList<>();
            for(int i = 0; i<plays.length; i++){
                if(genres[i].equals(key)){
                    arr.add(new Pair(plays[i], i));
                }
            }
            arr.sort((a1, a2) -> {
                if(a1.first.equals(a2.first)){
                    return a1.second - a2.second;
                }
                return a2.first-a1.first;
            });
            for(int i = 0; i<Math.min(arr.size(), 2); i++){
                answer.add(arr.get(i).second);
            }
		}
        
        return answer;
    }
}