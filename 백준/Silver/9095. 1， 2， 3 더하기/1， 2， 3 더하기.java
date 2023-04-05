import java.util.Scanner;

public class Main {
	static int[] dp = new int[11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			System.out.println(check(sc.nextInt()));
		}
	}

	static int check(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return dp[n];
		}
		return check(n - 1) + check(n - 3) + check(n - 2);

	}
}