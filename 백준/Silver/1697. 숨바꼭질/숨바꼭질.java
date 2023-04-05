import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int n;
	static int k;
	static int[] time = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 수빈이
		k = sc.nextInt(); // 동생
		if (n >= k) {
			System.out.println(n - k);
		} else {

			bfs();
			System.out.println(min);
		}

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		time[n] = 1;
		while (!q.isEmpty()) {
			int a = q.poll();

			if (min < time[a])
				return;

			for (int i = 0; i < 3; i++) {
				int b;
				if (i == 0) {
					b = a + 1;
				} else if (i == 1) {
					b = a - 1;
				} else {
					b = a * 2;
				}

				if (b < 0 || b > 100000)
					continue;

				if (b == k) {
					min = time[a];
				}

				if (time[b] == 0 || time[b] == time[a] + 1) {
					q.add(b);
					time[b] = time[a] + 1;
				}
			}
		}
	}
}