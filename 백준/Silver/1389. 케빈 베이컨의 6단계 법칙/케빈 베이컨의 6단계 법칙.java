import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] rel = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			rel[a][b] = 1;
			rel[b][a] = 1;
		}
		int res = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int[] sum = new int[n + 1];
			boolean[] vis = new boolean[n+1];
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			vis[i] = true;
			while (!q.isEmpty()) {
				int a = q.poll();
				for (int j = 1; j <= n; j++) {
					if (rel[a][j] == 1 && !vis[j]) {
						q.add(j);
						vis[j] = true;
						sum[j] = sum[a]+1;
					}
				}
			}
			int s = 0;
			for(int j = 1; j<=n; j++) {
				s += sum[j];
			}
			if(s<min) {
				min = s;
				res = i;
			}
		}
		System.out.println(res);
	}
}