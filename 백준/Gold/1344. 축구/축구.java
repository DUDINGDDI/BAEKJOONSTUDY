import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		double A = 0, B = 0;
//		double A = Math.pow(1-n/(double)100, 18);
//		double B = Math.pow(1-m/(double)100, 18);
		double sum = 0;
		for (int i = 0; i <= 18; i++) {
			if (i == 1 || i == 0 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10 || i == 12 || i == 14 || i == 15
					|| i == 16 || i == 18) {
				A = comb(18, i) * Math.pow(n / (double) 100, i) * Math.pow(1 - n / (double) 100, 18 - i);
				for (int j = 0; j <= 18; j++) {
					if (j == 1 || j == 0 || j == 4 || j == 6 || j == 8 || j == 9 || j == 10 || j == 12 || j == 14
							|| j == 15 || j == 16 || j == 18) {
						B = comb(18, j) * Math.pow(m / (double) 100, j) * Math.pow(1 - m / (double) 100, 18 - j);
						sum += A * B;
					}
				}
			}
		}
		double res = 1 - sum;
		System.out.println(res);
	}

	public static int comb(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return comb(n - 1, r - 1) + comb(n - 1, r);
	}
}