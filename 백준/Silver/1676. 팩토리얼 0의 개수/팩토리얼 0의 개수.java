import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();


			int n = sc.nextInt();
			int cnt5 =0;
			for (int i = 5; i <= n; i *= 5) {
				cnt5+=n/i;
			}
			sb.append(cnt5);

		System.out.println(sb);
	}
}