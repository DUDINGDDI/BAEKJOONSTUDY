import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int end = sum;
		int start = 0;
		while (true) {
			int mid = (end + start) / 2;
			cnt = 0;
//			System.out.println(mid+"dkdkdk");
//			if (mid == end) {
//				System.out.println("뒤랑같"+start);
//				break;
//			}else if(mid == start) {
//				System.out.println("앞이랑같"+end);
//				break;
//			}
			if (check(mid)) {
				end = mid-1;
				if(mid == start) {
					System.out.println(mid);
					break;
				}
			} else {
				start = mid+1;
				if (mid == end) {
					System.out.println(start);
					break;
				}
			}
		}
	}

	static boolean check(int k) {
		int pocket = 0;
		for (int i = 0; i < n; i++) {
			if (pocket < arr[i]) {
				if (cnt < m) {
					pocket = k - arr[i];
					cnt++;
					if(pocket<0) {
						return false;
					}
				} else {
					return false;
				}
			} else {
				pocket -= arr[i];
				if (pocket < 0) {
					return false;
				}
			}
		}
		return true;
	}
}