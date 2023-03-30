import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int x = Integer.parseInt(str[1]);
		int[] arr = new int[n];
		str = br.readLine().split(" ");
		int[] res = new int[n - x+1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
			
		}
		int idx = 0;
		int max = 0;
		int sum = 0;
		for (int j = 0; j < x; j++) {
			sum += arr[j];
		}
		max = sum;
		res[0] = sum;
		for (int i = x; i < n ; i++) {
			sum -= arr[i-x];
			sum += arr[i];
			
			if (sum > max) {
				max = sum;
			}
			res[i-x+1] = sum;
		}
		for (int i = 0; i <= n - x; i++) {
			if (res[i] == max) {
				idx++;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(idx);
		}
	}
}