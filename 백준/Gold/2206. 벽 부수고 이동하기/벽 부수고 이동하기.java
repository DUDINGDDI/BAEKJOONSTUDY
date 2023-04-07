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
			this.x = x; // 행
			this.y = y; // 열
			this.z = z; // 벽을 부순적있는가
		}
	}

	static int n;
	static int m;
	static int[][] arr; // 미로
	static int[][][] res; // 길의 결과값을 저장하는 배열
	static int[] dc = { -1, 1, 0, 0 }; // 방향전환 배열
	static int[] dr = { 0, 0, 1, -1 };
	static int resss = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		res = new int[n][m][2]; // 벽을 부수고간 숫자인지, 부순적없는 숫자인지를 구분하는 결과값을 저장해주려 한다
		for (int i = 0; i < n; i++) { // 3차원 배열에 최대값을 넣어놓는다
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 2; k++) {
					res[i][j][k] = 111111111;
				}
			}
		}
		for (int i = 0; i < n; i++) { // 미로에 값넣기
			String[] a = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(a[j]);
			}
		}
		bfs(0, 0, 0); // 0,0 에서 한번도 벽 부순적 없다에서 시작

		int a = res[n - 1][m - 1][0];
		int b = res[n - 1][m - 1][1];
		if (a == 111111111 && b == 111111111) { // 마지막값이 변환되었는지 확인하기위해
			System.out.println(-1);
		} else {
			System.out.println(Math.min(a, b)); // 변환되어있으면 그중에 작은거 뽑아내기
		}
	}

	static void bfs(int a, int b, int bbang) { // 0,0 에서 한번도 벽 부순적 없다에서 시작
		Queue<pair> q = new LinkedList<pair>();
		q.add(new pair(a, b, bbang));
		res[a][b][bbang] = 1; // 시작값에 1넣기
		while (!q.isEmpty()) {
			pair p = q.poll(); // 하나 뽑아내고
			if (p.x == n - 1 && p.y == m - 1) {
				break;
			}
			for (int i = 0; i < 4; i++) { // 네방향 순회
				int x = p.x + dc[i];
				int y = p.y + dr[i];
				if (check(x, y) && res[x][y][p.z] == 111111111) { // 배열을 안벗어나고, 방문한적 없으면(값이바뀐적없다)
					if (arr[x][y] == 0) { // 벽이 아닐때
						res[x][y][p.z] = res[p.x][p.y][p.z] + 1; // 벽부슨적 있는지없는지를 들고 1을 더한값을 다음에 저장
						q.add(new pair(x, y, p.z));
					}
					if (p.z == 0 && arr[x][y] == 1) { // 벽을 부순적 없고, 벽일때
						res[x][y][1] = res[p.x][p.y][p.z] + 1; // res의 1번 배열에 그이전값에 1을 더한값 저장
						q.add(new pair(x, y, 1));
					}
				}
			}

		}
	}

	static boolean check(int x, int y) { // 배열을 벗어났는지 체크
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		} else {
			return true;
		}
	}
}