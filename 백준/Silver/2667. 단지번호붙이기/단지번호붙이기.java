import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static char[][] arr;
	static int n;
	static int[] dc = {-1, 1, 0, 0};
	static int[] dr = {0, 0, 1, -1};
	static int cnt = 0;	//단지내 건물수
	static int count = 0;	//단지수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<>();
		n = sc.nextInt();
		arr = new char[n][n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]!='0') {
					arr[i][j] = '0';
					cnt = 1;
					building(i, j);
					al.add(cnt);
					count++;
				}
			}
		}
		Collections.sort(al);
		System.out.println(count);
		for(int i =0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}
	static void building(int x, int y) {
		for(int i = 0; i<4; i++) {
			int a = x+dc[i];
			int b = y+dr[i];
			if(check(a,b)&&arr[a][b]!='0') {
				arr[a][b] = '0';
				cnt++;
				building(a, b);
			}
		}
	}
	static boolean check(int x, int y) {
		if(x<0||y<0||x>=n||y>=n) {
			return false;
		}else {
			return true;
		}
	}
}