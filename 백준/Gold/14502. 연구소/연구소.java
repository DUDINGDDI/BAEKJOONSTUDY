import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair3 {
		int x;
		int y;

		Pair3(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int min = 10000;
	static int max = 0;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };
	static int n;
	static int m;
	static int[][] arr;
	static boolean vi[][];
	static int cnt = 0;
	static ArrayList<Pair3> virus = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int cnt2 = 0;
		int[][] ar = new int[n][m];
		arr = new int[n][m];
		vi = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ar[i][j] = sc.nextInt();
				if (ar[i][j] == 2) {
					virus.add(new Pair3(i, j));
				}
				if(ar[i][j]==0) {
					cnt2++;
				}
			}
		}
		for (int kk = 0; kk < n; kk++) {
			arr[kk] = ar[kk].clone();
		}

//		for (int ii = 0; ii< n; ii++) {
//			System.out.println(Arrays.toString(arr[ii]));
//		}
//		
		for (int i = 0; i < (n * m - 2); i++) {
			if (arr[i / m][i % m] == 0) {
				for (int j = i + 1; j < n * m - 1; j++) {
					if (arr[j / m][j % m] == 0) {
						for (int k = j + 1; k < n * m; k++) {
							if (arr[k / m][k % m] == 0) {
								arr[i / m][i % m] = 1;
								arr[j / m][j % m] = 1;
								arr[k / m][k % m] = 1;
//								System.out.println(i + " " + j + " " + k);
								cnt = 0;
								for (int ijk = 0; ijk < virus.size(); ijk++) {
//									System.out.println(virus.get(ijk).x+" "+virus.get(ijk).y);
									bfs(virus.get(ijk).x, virus.get(ijk).y);
								}
//								for (int ii = 0; ii< n; ii++) {
//									System.out.println(Arrays.toString(arr[ii]));
//								}
								count();
//								if(cnt!=0)
//									min = Math.min(cnt, min);
								max = Math.max(cnt, max);
								for (int kk = 0; kk < n; kk++) {
									arr[kk] = ar[kk].clone();
								}
								vi = new boolean[n][m];
							}
						}
					}
				}
			}
		}
		System.out.println(max);
//		if(min==10000)
//			min = 0;
//		vi[0][1] = true;
//		bfs(0, 1);
//		System.out.println(cnt2);
//		System.out.println(min);
//		System.out.println((cnt2-min-3));
	}// main

//	static void bfs(int a, int b) {
//		Queue<Pair3> q = new LinkedList<>();
//		q.add(new Pair3(a, b));
//
//		while (!q.isEmpty()) {
//			Pair3 p = q.poll();
//			for (int i = 0; i < 4; i++) {
//				int x = p.x + dr[i];
//				int y = p.y + dc[i];
//
//				if (check(x, y) && vi[x][y] == false && arr[x][y] == 0) {
//					q.add(new Pair3(x, y));
//					arr[x][y] = 2;
//					cnt++;
////					System.out.println(cnt);
//					if (cnt > min) {
//						return;
//					}
//					vi[x][y] = true;
//				}
//			}
//		}
//
//	}
	static void count() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j]==0) {
					cnt++;
				}
			}
		}
	}
	static void bfs(int a, int b) {
		for (int j = 0; j < 4; j++) {
			int x = a + dr[j];
			int y = b + dc[j];
			if (check(x, y) && arr[x][y] == 0) {
				arr[x][y] = 2;
//				cnt++;
				bfs(x,y);
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