import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;

        // 맵: 선수 이름 -> 순위 (0부터 시작하는 인덱스)
        HashMap<String, Integer> playerToRank = new HashMap<>();
        // 맵: 순위 (0부터 시작하는 인덱스) -> 선수 이름
        HashMap<Integer, String> rankToPlayer = new HashMap<>();

        // 초기 선수 순서에 따라 두 맵 모두 초기화
        for (int i = 0; i < n; i++) {
            playerToRank.put(players[i], i);
            rankToPlayer.put(i, players[i]);
        }

        // 각 calling 처리
        for (String calledPlayer : callings) {
            // 1. 불린 선수의 현재 순위 가져오기
            int currentRank = playerToRank.get(calledPlayer);

            // 이미 1등(순위 0)인 경우 추월 불가
            if (currentRank == 0) {
                continue;
            }

            // 2. 추월당하는 선수 식별 (순위 - 1의 선수)
            int overtakenRank = currentRank - 1;
            String overtakenPlayer = rankToPlayer.get(overtakenRank);

            // 3. playerToRank 맵에서 순위 업데이트
            playerToRank.put(calledPlayer, overtakenRank); // 불린 선수는 순위 상승
            playerToRank.put(overtakenPlayer, currentRank); // 추월당한 선수는 순위 하락

            // 4. rankToPlayer 맵에서 선수 업데이트
            rankToPlayer.put(overtakenRank, calledPlayer);   // 추월당한 순위에는 이제 불린 선수가 위치
            rankToPlayer.put(currentRank, overtakenPlayer); // 원래 순위에는 이제 추월당한 선수가 위치
        }

        // 5. 최종 순위에 따라 결과 배열 생성
        // 이제 rankToPlayer 맵이 최종 순서를 정확하게 저장하고 있음
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = rankToPlayer.get(i); // i 순위의 선수 가져오기
        }

        return answer;
    }
}