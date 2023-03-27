import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };
	static int n;
	static int m;
	static int[][] arr;
	static boolean vi[][];
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); 
		int[][] ar = new int[n][m];
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] a = sc.nextLine().split("");
			for (int j = 0; j < m; j++) {
				if (a[j].equals("W"))
					ar[i][j] = 0;
				else
					ar[i][j] = 1;

			}
		}
		int res = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				for(int k = 0; k<n;k++) {
					arr[k] = ar[k].clone();
				}
				max = 0;
				vi = new boolean[n][m];
				vi[i][j]=true;
				bfs(i,j);
				res = Math.max(max, res);
			}
		}

//		vi[0][1] = true;
//		bfs(0, 1);
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		System.out.println(res-1);
	}// main

	static void bfs(int a, int b) {
		Queue<Pair3> q = new LinkedList<>();
		q.add(new Pair3(a, b));

		while (!q.isEmpty()) {
			Pair3 p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dr[i];
				int y = p.y + dc[i];

				if (check(x, y) && vi[x][y] == false && arr[x][y] != 0) {
					q.add(new Pair3(x, y));
					arr[x][y] = arr[p.x][p.y] + 1;
					vi[x][y] = true;
					max = arr[x][y];
				}
			}
		}

	}

	static boolean check(int a, int b) {
		if (a >= 0 && a < n && b >= 0 && b < m) {
			return true;
		} else {
			return false;
		}
	}
}

class Pair3 {
	int x;
	int y;

	Pair3(int x, int y) {
		this.x = x;
		this.y = y;
	}
}