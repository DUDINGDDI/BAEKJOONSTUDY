import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[] arr;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(bf.readLine());
		arr = new Integer[x + 1];
		arr[0] = 0;
		arr[1] = 0;
		int a = dp(x);
		sb.append(a).append("\n");
		for (int i = x; i > 0; i--) {
			if (arr[i] == a) {
				if (i==x||i + 1 == x || i * 3 == x || i * 2 == x) {
					x=i;
					sb.append(i).append(" ");
					a--;
				}
			}
		}
		System.out.println(sb);
	}

	static int dp(int n) {
		if (arr[n] == null) {
			if (n % 6 == 0) {
				arr[n] = Math.min(dp(n - 1), Math.min(dp(n / 3), dp(n / 2))) + 1;
			} else if (n % 3 == 0) {
				arr[n] = Math.min(dp(n / 3), dp(n - 1)) + 1;
			} else if (n % 2 == 0) {
				arr[n] = Math.min(dp(n / 2), dp(n - 1)) + 1;
			} else {
				arr[n] = dp(n - 1) + 1;
			}
		}
		return arr[n];
	}
}