import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class pair {
		int x, y, z, dist;

		pair(int x, int y, int z, int dist) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.dist = dist;
		}
	}

	static int[] hr = { -2, -2, -1, -1, 1, 1, 2, 2 };// 말의 움직임
	static int[] hc = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] arr;
	static boolean[][][] dist;
	static int w, h, k;
	static int resss = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		arr = new int[h][w];
		dist = new boolean[h][w][k + 1];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		bfs(0, 0, 0, 0);
		System.out.println(resss);
	}

	static void bfs(int a, int b, int jp, int dis) {
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(a, b, jp, dis));
		dist[a][b][jp] = true;
		while (!q.isEmpty()) {
			pair p = q.poll();
			if (p.x == h - 1 && p.y == w - 1) {
				resss = p.dist;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int x = p.x + dr[i];
				int y = p.y + dc[i];
				if (check(x, y) && dist[x][y][p.z] == false && arr[x][y] == 0) {
					dist[x][y][p.z] = true;
					q.add(new pair(x, y, p.z, p.dist + 1));
				}
			}

			if (p.z < k) {
				for (int i = 0; i < 8; i++) {
					int x = p.x + hr[i];
					int y = p.y + hc[i];
					if (check(x, y) && dist[x][y][p.z+1] == false && arr[x][y] == 0) {
						dist[x][y][p.z + 1] = true;
						q.add(new pair(x, y, p.z + 1, p.dist + 1));
					}
				}
			}
		}
	}

	static boolean check(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w) {
			return false;
		} else {
			return true;
		}
	}
}