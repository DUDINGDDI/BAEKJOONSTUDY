import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		
		for(int i = 2; i<=n; i++) {
			dp[i] = arr[i];	//먼저 자신값 넣고
			for(int j = 1; j<i; j++) {	//처음부터i까지 비교
				if(arr[i]>arr[j]) {	//내가 앞에보다 큰경우
					dp[i] = Math.max(dp[j]+arr[i],dp[i]); //더 큰거 넣기
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}