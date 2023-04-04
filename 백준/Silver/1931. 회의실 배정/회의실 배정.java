import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] time = new int[N][2];

		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt(); // 시작시간
			time[i][1] = sc.nextInt(); // 종료시간
		}

		Arrays.sort(time, new Comparator<int[]>() {
    // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}

		});

		int count = 0;
		int last = 0;

		// 종료시간 이후 에 시작시간체크
		for (int i = 0; i < N; i++) {
			if (last <= time[i][0]) {
				last = time[i][1];
				count++;
			}
		}

		System.out.println(count);

	}
}