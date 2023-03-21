import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int start = 0;
			int end = n-1;
			int res = 0;
			while (end > start) {
				int mid = (start + end) / 2;
				if (arr[mid] < x) {
					start = mid+1;
				} else {
					end = mid;
				}
				if (arr[start] == x) {
					res = 1;
					break;
				} 
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}