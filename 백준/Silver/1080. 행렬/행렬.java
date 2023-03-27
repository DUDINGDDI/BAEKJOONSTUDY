import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static boolean[][] start;
	static boolean[][] end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = new boolean[n][m];
		end = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j<m; j++) {
				if(str[j].equals("1")) {
					start[i][j] = true;
				}
			}
		}
		for(int i = 0; i<n; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j<m; j++) {
				if(str[j].equals("1")) {
					end[i][j] = true;
				}
			}
		}
		
		int cnt = 0;
		
		for(int i =0; i<=n-3; i++) {
			for(int j = 0; j<=m-3; j++) {
				if(start[i][j] != end[i][j]) {
					toggle(i,j);
					cnt++;
				}
			}
		}
		if(same())
			System.out.println(cnt);
		else
			System.out.println(-1);
		
	}
	static void toggle(int r, int c) {
		for(int i = r; i<r+3; i++) {
			for(int j = c; j<c+3; j++) {
				start[i][j] = !start[i][j];
			}
		}
	}
	
	static boolean same() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(start[i][j] != end[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}