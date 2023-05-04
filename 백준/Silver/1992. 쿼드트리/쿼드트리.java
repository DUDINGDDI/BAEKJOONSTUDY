import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] str = sc.next().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str[j]-48;
			}
		}
		check(0, 0, n);
		System.out.println(sb);
	}

	static void check(int a, int b, int c) {
		int tmp = arr[a][b];
		for (int i = a; i < a + c; i++) {
			for (int j = b; j < b + c; j++) {
				if (arr[i][j] != tmp) {
					int d = c / 2;
					sb.append("(");
					check(a, b, d);
					check(a, b + d, d);
					check(a + d, b, d);
					check(a + d, b + d, d);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(tmp);
	}

}