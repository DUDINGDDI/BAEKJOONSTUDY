import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt = 0;
	static int[][] gr;
	static int inv = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nmb = br.readLine().split(" ");
		int n = Integer.parseInt(nmb[0]);
		int m = Integer.parseInt(nmb[1]);
		int b = Integer.parseInt(nmb[2]);

		gr = new int[n][m];
		int max = 0;
		int min = 261;
		for (int i = 0; i < n; i++) {
			String[] grRow = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt((grRow[j]));
				gr[i][j] = value;
				max = Math.max(max, value);
				min = Math.min(min, value);
			}

		}
		for (int i = 0; i < n; i++) {
		}
		int res = Integer.MAX_VALUE;
		int height = 0;
		m: for (int val = min; val <= max; val++) {
			cnt = 0;
			inv = b;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (gr[i][j] == val) {
						continue;
					} else if (gr[i][j] < val) {
						cnt += (val - gr[i][j]);
						inv -= (val - gr[i][j]);

					} else {
						cnt += 2*(gr[i][j] - val);
						inv += gr[i][j] - val;
					}
				}
			}
			if (inv < 0)
				continue m;

			if (res >= cnt) {
				res = cnt;
				height = val;
			}
		}
		System.out.println(res + " " + height);
	}

}