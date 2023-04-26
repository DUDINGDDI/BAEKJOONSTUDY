import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static HashSet<Integer> hs;
	static int[] bk;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int length = 1;

		int min = Integer.MAX_VALUE;
		int m = sc.nextInt();
		bk = new int[m];
		for (int i = 0; i < m; i++) {
			bk[i] = sc.nextInt();
		}
		int click = 0;

		click = Math.abs(n - 100);
//		System.out.println(click);
		min = Math.min(min, click);
		// 큰거 찾기
		int a = n;
		for (int i = 0; i < min; i++) {
			dev(a);
			if (contain(hs)) {
				break;
			}
			a++;
		}
		if (a != 0) {
			length = (int) (Math.log10(a) + 1);
		} else {
			length = 1;
		}
		click = a - n + length;
//		System.out.println("a" + a);
//		System.out.println("n" + n);
//		System.out.println("len" + length);
//		System.out.println(click);
		min = Math.min(min, click);
		// 작은거 찾기
		a = n;
		boolean c = true;
		for (int i = 0; i < min; i++) {
			dev(a);
			if (contain(hs)) {
				break;
			}
			a--;
			if (a < 0) {
				c = false;
				break;
			}
		}
		if (c) {
			if (a != 0) {
				length = (int) (Math.log10(a) + 1);
			} else {
				length = 1;
			}
			click = n - a + length;
//			System.out.println("a" + a);
//			System.out.println("n" + n);
//			System.out.println("len" + length);
//			System.out.println(click);
			min = Math.min(min, click);
		}
		// 결과
		System.out.println(min);
	}

	// 따로 떨어뜨리기
	static void dev(int r) {
		hs = new HashSet<>();
		hs.add(r % 10);
		r /= 10;
		while (r != 0) {
			hs.add(r % 10);
			r /= 10;
		}
	}

	// 버튼중에 숫자 없는지 확인
	static boolean contain(HashSet<Integer> h) {
		for (int i = 0; i < bk.length; i++) {
			if (h.contains(bk[i])) {
				return false;
			}
		}
		return true;
	}
}