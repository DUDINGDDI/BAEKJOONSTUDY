import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static long[] res;
	static long cnt = 0;
	static long ct = 0;
	static long[] depth;
	static boolean[] vis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();

		res = new long[n + 1];
		depth = new long[n + 1];
		vis = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b); // 양방향으로 링크
			graph.get(b).add(a);
		}
		for (int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
			Collections.reverse(graph.get(i));
		}

		ct = 1;
		
		dfs(r);
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (res[i] == 0 && i != r) {
				sum += (-1*res[i]);
			} else {
				sum += (depth[i]*res[i]);
			}
		}
		System.out.println(sum);
	}

	static void dfs(int r) {
		res[r] = ct;
		depth[r] = cnt;
		vis[r] = true;
		for (int i = 0; i < graph.get(r).size(); i++) {
			int nv = graph.get(r).get(i);
			if (!vis[nv]) {
				ct++;
				cnt++;
				dfs(nv);
				cnt--;
			}
		}
	}
}