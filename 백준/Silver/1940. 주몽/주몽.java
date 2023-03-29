import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		boolean[] vis = new boolean[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			if (vis[i] == false) {
				for (int j = i+1; j < n; j++) {
					if (vis[j] == false) {
						if (arr[i] + arr[j] == m) {
							cnt++;
							vis[i] = true;
							vis[j] = true;
							break;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}