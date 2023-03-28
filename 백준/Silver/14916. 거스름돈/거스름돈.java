import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = Integer.MAX_VALUE;
		int a = n / 5;

		for (int i = a; i >= 0; i--) {
			int b = n - 5 * i;
			if (b % 2 != 0) {
				continue;
			} else {
				sum =Math.min(sum, b / 2 + i);
			}
		}
		if (sum == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}
	}
}