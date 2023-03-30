import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[] arr = new int[n];
		int[] vis;
		str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int max = 0;
		vis = new int[1000001];
		int cnt = 0;
		int start = 0;
		for (int j = 0; j < n; j++) {
			vis[arr[j]]++;
			if (vis[arr[j]] > k) {
				max = Math.max(max, cnt);
				while (true) {
					vis[arr[start]]--;
					cnt--;
					if (arr[start] == arr[j]) {
						start++;
						break;
					}
					start++;
				}
			}
			cnt++;
		}
		max = Math.max(max, cnt);
		System.out.println(max);
	}
}