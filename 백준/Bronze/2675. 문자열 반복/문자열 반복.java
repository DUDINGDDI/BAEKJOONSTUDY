import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			String str = sc.next();

			char[] ar = str.toCharArray();
			String res = "";
			for (char aa : ar) {
				for (int i = 0; i < n; i++) {
					res += aa;
				}
			}
			System.out.println(res);
		}
	}
}