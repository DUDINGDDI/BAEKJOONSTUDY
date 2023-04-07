import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class pair {
		int x, y, z;

		pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int n;
	static int m;
	static int[][] arr;
	static int[][][] res;
	static boolean[][] vis;
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, 1, -1 };
	static int min = 111111111;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vis = new boolean[n][m];
		arr = new int[n][m];
		res = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 2; k++) {
					res[i][j][k] = 111111111;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			String[] a = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(a[j]);
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

//		vis[0][0] = true;
		dfs(0, 0, 0);

//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(res[i]));
//		}
//		if (res[n-1][m-1] == 111111111) {
//			System.out.println(-1);
//		} else {
//			System.out.println(res[n-1][m-1]);
//		}
		int a = res[n - 1][m - 1][0];
		int b = res[n - 1][m - 1][1];
		if(a==111111111&&b==111111111) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(a, b));
		}
//		System.out.println(res[n - 1][m - 1][0]);
//		System.out.println(res[n - 1][m - 1][1]);
	}

	static void dfs(int a, int b, int bbang) {
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(a, b, bbang));
		vis[a][b] = true;
		res[a][b][bbang] = 1;
		while (!q.isEmpty()) {
			pair p = q.poll();
			vis[p.x][p.y] = true;
			for (int i = 0; i < 4; i++) {
				int x = p.x + dc[i];
				int y = p.y + dr[i];
				if (check(x, y) && res[x][y][p.z]==111111111) {
					if (arr[x][y] == 0) {
						res[x][y][p.z] = Math.min(res[x][y][p.z], res[p.x][p.y][p.z] + 1);
//						vis[x][y] = true;
						q.add(new pair(x, y, p.z));
					}
					if (p.z == 0 && arr[x][y] == 1) {
						res[x][y][1] = Math.min(res[x][y][p.z], res[p.x][p.y][p.z] + 1);
//						vis[x][y] = true;
						q.add(new pair(x, y, 1));
					}
				}
			}
			
////			System.out.println("0==========================");
//			for (int i = 0; i < n; i++) {
//				for(int j = 0; j<m; j++) {
//					System.out.print(res[i][j][0]+" ");;
//				}
//				System.out.println();
//			}
////			System.out.println("1=========dldld===========");
//			for (int i = 0; i < n; i++) {
//				for(int j = 0; j<m; j++) {
//					System.out.print(res[i][j][1]+" ");;
//				}
//				System.out.println();
//			}
		}
	}

	static boolean check(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		} else {
			return true;
		}
	}
}