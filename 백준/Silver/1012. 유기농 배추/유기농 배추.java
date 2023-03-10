import java.util.Scanner;

public class Main {
	static int[][] graph;
	static int n;
	static int m;
	static int cnt = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t<tc; t++) {
		n = sc.nextInt();
		m = sc.nextInt();
		int s = sc.nextInt();
		graph = new int[n][m];
		for (int i = 0; i < s; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}

		for (int i = 0; i < n; i++) {
			for(int j = 0; j<m; j++) {
				if(graph[i][j]==1) {
					cnt++;
					dfs(i,j);
				}
			}
		}
		System.out.println(cnt);
		cnt = 0;
	}
	}
	static void dfs(int a, int b) {
		graph[a][b] = 0;

		for (int j = 0; j < 4; j++) {
			int x = a + dr[j];
			int y = b + dc[j];
			if (dir(x, y) && graph[x][y] == 1) {
				dfs(x,y);
			}
		}
	}

	static boolean dir(int a, int b) {
		if (a >= 0 && b >= 0 && a < n && b < m) {
			return true;
		} else {
			return false;
		}
	}
}