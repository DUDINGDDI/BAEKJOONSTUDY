import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int loc = 1;
		int cnt = 0;
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			while (true) {
				if (loc <= a && loc + m > a) {
					break;
				} else if (a < loc) {
					loc--;
					cnt++;
				} else {
					loc++;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}