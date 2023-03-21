import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		char[][] bd = new char[m][n];
		for (int i = 0; i < m; i++) {
			String a = sc.next();
			bd[i] = a.toCharArray();
		}
		char[] BW = { 'B', 'W' };
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m - 7; i++) {
			for (int j = 0; j < n - 7; j++) {
				int cnt = 0;
				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						if(bd[x][y]!=BW[(y+x)%2]) {
							cnt++;
						}
					}
				}
				min = Math.min(min, cnt);
				cnt = 0;
				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						if(bd[x][y]!=BW[(y+x+1)%2]) {
							cnt++;
						}
					}
				}
				min = Math.min(min, cnt);
			}
		}
		System.out.println(min);
	}
}