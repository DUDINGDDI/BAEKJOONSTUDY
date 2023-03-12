
import java.util.Scanner;

public class Main {
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		char[][] arr = new char[n][n];
		char[][] arr1 = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			arr[i] = str.toCharArray();
			arr1[i] = str.toCharArray();
		}
		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr1[i][j] == 'G')
					arr1[i][j] = 'R';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'R' || arr[i][j] == 'G' || arr[i][j] == 'B') {
					dfs(i, j, arr);
					cnt1++;
				}
				if (arr1[i][j] == 'R' || arr1[i][j] == 'G' || arr1[i][j] == 'B') {
					dfs(i, j, arr1);
					cnt2++;
				}
				

			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}// main

	static void dfs(int a, int b, char[][] arr) {
		int ch = arr[a][b];
		arr[a][b] = 'c';

		for (int i = 0; i < 4; i++) {
			int r = a + dr[i];
			int c = b + dc[i];
			if (check(r, c) && arr[r][c] == ch) {
				dfs(r, c, arr);
			}
		}
	}



	static boolean check(int a, int b) {
		if (a >= 0 && a < n && b >= 0 && b < n) {
			return true;
		} else {
			return false;
		}
	}
}
