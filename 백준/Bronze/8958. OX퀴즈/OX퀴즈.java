import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			char[] arr = sc.next().toCharArray();
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			System.out.println(sum);
		}
	}
}