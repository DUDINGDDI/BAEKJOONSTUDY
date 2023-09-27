import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }
        List<Integer> l = new ArrayList<>(hs);
        int[] answer = new int[hs.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = l.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}