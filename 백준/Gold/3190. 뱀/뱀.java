import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] board;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static List<int[]> snake = new ArrayList<>();
	static HashMap<Integer, Character> hash = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int time = 0;

		int apple = sc.nextInt();
		// 사과 -1, 뱀 1, 땅 0
		board = new int[n][n];
		for (int i = 0; i < apple; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			board[x - 1][y - 1] = -1;
		}

		int turn = sc.nextInt();
		for (int i = 0; i < turn; i++) {
			int go = sc.nextInt();
			char dir = sc.next().charAt(0);
			hash.put(go, dir);
		}

		int nx = 0;
		int ny = 0;
		snake.add(new int[] { 0, 0 });
		int dir = 0;
		while (true) {
			// 시간증가
			time++;
			// 방향으로 가기
			nx += dx[dir];
			ny += + dy[dir];
//			System.out.println(nx + " "+ ny);
			// 끝나는지 체크
			if (isFinish(nx, ny)) {
				break;
			}
			// 진행
			if (board[nx][ny] == -1) {
				board[nx][ny] = 0;
				snake.add(new int[] { nx, ny });
			} else {
				snake.add(new int[] { nx, ny });
				snake.remove(0);
			}

			// 방향 변경
			if (hash.containsKey(time)) {
				if (hash.get(time) == 'L') {

					if (dir == 0)
						dir = 3;
					else
						dir--;
				} else {
					if (dir == 3)
						dir = 0;
					else
						dir++;

				}
			}
		}
		System.out.println(time);
	}

	public static boolean isFinish(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n) {
//			System.out.println("벽이닷");
			return true;
		}

		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);
			if (x == t[0] && y == t[1]) {
//				System.out.println("몸이닷");
				return true;
			}
		}
		return false;
	}
}