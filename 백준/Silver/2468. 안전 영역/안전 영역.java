import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] copy;
	static int n;
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, 1, -1 };
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max = Integer.MIN_VALUE;
		n = sc.nextInt();
		int[][] cheeze = new int[n][n];
		int maxday = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cheeze[i][j] = sc.nextInt();
				maxday = Math.max(cheeze[i][j], maxday);
			}
		}
		copy = new int[n][n];
		for (int day = 0; day <= maxday; day++) { // 날

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) { // 배열 전체돌면서
					if (cheeze[i][j] == day) {
						cheeze[i][j] = -1;
					} // 치즈 먹기
				}
			}
			for (int k = 0; k < n; k++) {
				copy[k] = cheeze[k].clone(); // 배열 복사하고
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) { // 배열 전체돌면서
					if (copy[i][j] != 0 && copy[i][j] != -1) {
						count(i, j);
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}

	static void count(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + dc[i];
			int dy = y + dr[i];
			if (check(dx, dy) && copy[dx][dy] != 0 && copy[dx][dy] != -1) {
				copy[dx][dy] = 0;
				count(dx, dy);
			}
		}
	}

	static boolean check(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n) {
			return true;
		} else {
			return false;
		}
	}
}