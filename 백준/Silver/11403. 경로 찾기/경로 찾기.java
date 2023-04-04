import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int[][] res;
	static int[][] arr;
	static boolean[] vis;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		arr = new int[n][n];
		res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			vis = new boolean[n];
			dfs(i, i);
		}
		for (int i = 0; i < n; i++) {
			for(int j = 0; j<n; j++) {
				sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int s, int e) {
//		vis[s] = true;
		for (int i = 0; i < n; i++) {
			if (arr[s][i] == 1 && !vis[i]) {
				vis[i] = true;
				res[e][i] = 1;
				dfs(i, e);
			}
		}
	}
}