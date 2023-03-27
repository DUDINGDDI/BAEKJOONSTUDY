import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n;
	static int m;
	static int min = Integer.MAX_VALUE;
	static int sum;
	static int[] dc = { -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				dnm(0, i, j);
			}
		}

		System.out.println(min);
	}

	static void dnm(int r, int c, int dir) {
		if (sum > min) {
			return;
		}
		if (r == n) {
//			System.out.println("합" + sum);
			min = Math.min(min, sum);
			return;
		}

		sum += arr[r][c];
		for (int i = 0; i < 3; i++) {
			if(i==dir) continue;
			int y = c + dc[i];
			if (check(y)) {
//				System.out.println(y);
				dnm(r + 1, y, i);
			}
		}
		sum -= arr[r][c];
	}

	static boolean check(int x) {
		if (x >= 0 && x < m)
			return true;
		else
			return false;
	}
}