import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int[] arr;
	static int n;
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp = new int[n];
		dp[0] = arr[0];
		for(int i = 1; i<n; i++) {
			dp(i);
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}
	static void dp(int a) {
		if(arr[a]>dp[a-1]+arr[a]) {
			dp[a] = arr[a];
		}else {
			dp[a] = dp[a-1]+arr[a];
		}
	}
}