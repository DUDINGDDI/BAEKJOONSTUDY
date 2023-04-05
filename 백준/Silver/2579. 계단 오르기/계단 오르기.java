import java.util.Scanner;

public class Main {
	static int n;
	static int[] stair;
	static int max = 0;
	static int dp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		stair = new int[n + 1]; // 시작지점 생각
		for (int i = 1; i <= n; i++) { // 계단 1번계단 부터
			stair[i] = sc.nextInt();
		}
		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = stair[1];
		if (n >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);

		}
		System.out.println(dp[n]);
	}

}