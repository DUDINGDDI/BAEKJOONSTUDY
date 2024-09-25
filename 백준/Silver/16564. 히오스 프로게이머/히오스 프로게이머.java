import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 캐릭터 개수
		int k = sc.nextInt(); // 올릴수 있는 레벨 총합

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		int l = arr[0]; // 제일 적은 값은 아무 것도 더해지지 않은 제일 낮은 레벨
		int h = arr[0] + k; // 제일 큰 값은 제일 낮은 레벨이 K의 모든 값을 취하는 경우 (이후의 [1], [2], ...는 더해줄 필요가 없을 때)

		int mid, ans = arr[0];
		while (l <= h) {
			mid = (l + h) >> 1;

			// 가지고 있는 K의 값 범위 내에서 기준 값 mid에 맞춰 모두 나눠줄 수 있는가
			long sum = 0;

			int diff;
			for (int i = 0; i < n; ++i) {
				diff = mid - arr[i];
				if (0 < diff) {
					sum += diff;
				}
			}

			// 남은 차(diff)의 값을 더한 sum 값이 K의 범위 안에 들어올 때 --> 답이 될 수 있음!
			if (sum <= k) {
				ans = Math.max(ans, mid);
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		System.out.print(ans);
	}
}