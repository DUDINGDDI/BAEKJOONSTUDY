import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class pair {
		int x, y, z;

		pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static List<pair> list = new ArrayList<>();
	static boolean[] vis;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		vis = new boolean[m + 1];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a >= 0 && b <= m && b - a > c)
				list.add(new pair(a, b, c));
		}
		Collections.sort(list, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return o1.x - o2.x;
			}

		});
		int idx = 0, move = 0;
		int[] dist = new int[10001];
		Arrays.fill(dist, 10001);
		dist[0] = 0;

		while (move < m) {
			if (idx < list.size()) {
				pair r = list.get(idx);
				if (move == r.x) {
					dist[r.y] = Math.min(dist[move] + r.z, dist[r.y]);
					idx++;
				} else {
					dist[move +1] = Math.min(dist[move+1], dist[move]+1);
					move++;
				}
			}else {
				dist[move+1] = Math.min(dist[move+1], dist[move]+1);
				move++;
			}
		}
		System.out.println(dist[m]);
	}
}