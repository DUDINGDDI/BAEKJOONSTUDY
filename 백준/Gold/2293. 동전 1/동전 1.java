import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] check = new int[k + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i <= k; i++) {
			if (i % arr[0] == 0) {
				check[i] = 1;
			}
		}
		for (int j = 1; j < n; j++) {
			for (int i = arr[j]; i <= k; i++) {
				check[i] += check[i - arr[j]];
			}
		}
		System.out.println(check[k]);
	}
}