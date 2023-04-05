import java.util.Scanner;

public class Main {
	static int cnt0;
	static int cnt1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] arr0 = new int[41];
		int[] arr1 = new int[41];
		arr0[0] = 1;
		arr1[0] = 0;
		arr0[1] = 0;
		arr1[1] = 1;
		for(int i = 2; i<=40; i++) {
			arr0[i] = arr0[i-1]+arr0[i-2];
			arr1[i] = arr1[i-1]+arr1[i-2];
		}
		
		for (int t = 1; t <= tc; t++) {
//			cnt0 = 0;
//			cnt1 = 0;

//			fibonacci(sc.nextInt());
			int a = sc.nextInt();
			System.out.println(arr0[a] + " " + arr1[a]);
		}
	}

//	static int fibonacci(int n) {
//		if (n == 0) {
//			cnt0++;
//			return 0;
//		} else if (n == 1) {
//			cnt1++;
//			return 1;
//		} else {
//			return fibonacci(n - 1) + fibonacci(n - 2);
//		}
//
//	}
}