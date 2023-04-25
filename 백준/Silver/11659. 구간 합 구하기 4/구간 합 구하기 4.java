import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = sc.nextInt() + dp[i - 1];
		}
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sb.append(dp[b]-dp[a-1]+"\n");
		}
		System.out.println(sb);
	}
}