import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class pair {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int[][] res;
	static pair p;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		res = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = sc.nextInt();
				map[i][j] = a;
				if (a == 2) {
					p = new pair(i, j);
					visited[i][j] = true;
				}
			}
		}
		bfs();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!visited[i][j]&&map[i][j]!=0) {
					res[i][j] = -1;
				}
				sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<pair> pq = new LinkedList<pair>();
		pq.add(p);
		while (!pq.isEmpty()) {
			pair polledP = pq.poll();
			for (int i = 0; i < 4; i++) {
				int x = polledP.x - dx[i];
				int y = polledP.y - dy[i];
				if (out(x, y) && !visited[x][y] && map[x][y] != 0) {
					res[x][y] = res[polledP.x][polledP.y] + 1;
					visited[x][y] = true;
					pq.add(new pair(x, y));
				}
			}
		}
	}

	public static boolean out(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		return true;
	}
}