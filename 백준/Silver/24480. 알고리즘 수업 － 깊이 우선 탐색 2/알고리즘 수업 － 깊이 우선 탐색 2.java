import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] res;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();

		res = new int[n + 1];

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

		cnt = 1;
		dfs(r);

		for (int i = 1; i <= n; i++) {
			sb.append(res[i] + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r) {
		res[r] = cnt;

		for (int i = 0; i < graph.get(r).size(); i++) {
			int nv = graph.get(r).get(i);
			if (res[nv] == 0) {
				cnt++;
				dfs(nv);
			}
		}
	}
}