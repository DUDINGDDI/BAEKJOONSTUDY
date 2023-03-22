import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] name;
	static int n;
	static int[] res;
	static int min;
	static int[] a;
	static int[][] arr;
	static int sum;
	static ArrayList<Integer> aaa;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		aaa = new ArrayList<>();
		a = new int[2];
		min = Integer.MAX_VALUE;
		n = sc.nextInt();
		name = new int[n];
		for (int i = 0; i < n; i++) {
			name[i] = i;
		}
		res = new int[n / 2];
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		combName(0, 0);
		for (int i = 0; i < aaa.size(); i++) {
			min = Math.min(min, Math.abs(aaa.get(i) - aaa.get(aaa.size() - i - 1)));
		}
		System.out.println(min);
	}

	// n = size;
	// r = 2;
	public static void combName(int idx, int sidx) {
		if (sidx == n / 2) {
//			int sum = Math.abs(res[0]-res[1]);
//			System.out.println(sum);
			sum = 0;
			comb(0, 0, res);
			aaa.add(sum);

			return;
		}
		if (idx == n) {
			return;
		}
		res[sidx] = name[idx];
		combName(idx + 1, sidx + 1);
		combName(idx + 1, sidx);

	}

	public static void comb(int idx, int sidx, int[] ires) {
		if (sidx == 2) {
			sum += arr[a[0]][a[1]];
			sum += arr[a[1]][a[0]];

			return;
		}
		if (idx == n / 2) {
			return;
		}
		a[sidx] = ires[idx];
		comb(idx + 1, sidx + 1, ires);
		comb(idx + 1, sidx, ires);

	}
}