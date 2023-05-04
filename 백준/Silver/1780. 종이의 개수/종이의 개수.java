import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n, cnt1, cnt2, cnt3; //-1, 0, 1 순서 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		check(0, 0, n);
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
		
	}
	static void check(int a, int b, int c) {
		int tmp = arr[a][b];
		for(int i = a; i<a+c; i++) {
			for(int j = b; j<b+c; j++) {
				if(arr[i][j]!=tmp) {
					int d = c/3;
					check(a, b, d);
					check(a+d, b, d);
					check(a+2*d, b, d);
					check(a, b+d, d);
					check(a+d, b+d, d);
					check(a+2*d, b+d, d);
					check(a, b+2*d, d);
					check(a+d, b+2*d, d);
					check(a+2*d, b+2*d, d);
					return;
				}
			}
		}
		switch (tmp) {
		case -1:
			cnt1++;
			break;
		case 0:
			cnt2++;
			break;
		case 1:
			cnt3++;
			break;
		}
	}

}