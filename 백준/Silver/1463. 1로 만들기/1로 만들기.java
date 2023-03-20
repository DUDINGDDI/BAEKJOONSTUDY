import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(dp(n,0));
	}
	static int dp(int n, int cnt) {
		if(n<2) {
			return cnt;
		}
		return Math.min(dp(n/2, cnt +1 +(n%2)), dp(n/3, cnt+1+(n%3)));
	}
//	static Integer[] arr;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int x = sc.nextInt();
//		arr = new Integer[x + 1];
//		arr[0] = 0;
//		arr[1] = 0;
//
//		System.out.println(dp(x));
//
//	}
//
//	static int dp(int n) {
//		if (arr[n] == null) {
//
//			if (n % 6 == 0) {
//				arr[n] = Math.min(dp(n-1), Math.min(dp(n/3), dp(n/2)))+1;
//			} else if (n % 3 == 0) {
//				arr[n] = Math.min(dp(n-1), dp(n/3))+1;
//			} else if (n % 2 == 0) {
//				arr[n] = Math.min(dp(n-1), dp(n/2))+1;
//			} else {
//				arr[n] = dp(n-1)+1;
//			}
//		}
//		return arr[n];
//	}
}