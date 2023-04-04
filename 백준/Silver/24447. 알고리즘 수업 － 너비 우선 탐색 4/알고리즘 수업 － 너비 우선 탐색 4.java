import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static long[] vi;
	static long[] count;
	static boolean[] vis;
	static List<List<Integer>> l = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int s = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			l.add(new ArrayList<>());
		}
		vi = new long[n + 1];
		vis = new boolean[n + 1];
		count = new long[n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			l.get(a).add(b);
			l.get(b).add(a);

		}
		for (int i = 0; i <= n; ++i) {
			Collections.sort(l.get(i));
		}

		bfs(s);
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (vi[i] == 0 && i != s)
				sum += (-1 * count[i]);
			else {
				sum += (vi[i] * count[i]);
			}
		}
		System.out.println(sum);
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		long cnt = 1;

		q.offer(s);
		vis[s] = true;
		vi[s] = 0;
		count[s] = cnt++;
		while (!q.isEmpty()) {
			int a = q.poll();

			for (int i = 0; i < l.get(a).size(); i++) {
				int next = l.get(a).get(i);

				if (vis[next])
					continue;

				q.offer(next);
				vis[next] = true;
				vi[next] = vi[a] + 1;
				count[next] = cnt++;
			}
		}

	}
}