import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long a = n / 5;
		long obaek = 0;
		long sambaek = 0;
		long idx = 0;
		for (long i = a; i >= 0; i--) {
			if ((n - 5 * i) % 3 == 0) {
				obaek = i;
				sambaek = (n - 5 * i) / 3;
				idx = 1;
				break;
			}
		}
		if (idx == 1) {
			System.out.println(obaek + sambaek);

		} else {
			System.out.println(-1);
		}
	}
}