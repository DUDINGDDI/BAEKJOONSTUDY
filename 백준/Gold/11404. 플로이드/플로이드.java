import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] dist = new int[v + 1][v + 1];
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = 987654321;
			}
		}

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			dist[a][b] = Math.min(dist[a][b], w);
		}
		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				for (int j = 1; j <= v; j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				// 연결이 안되어 있는 경우
				if (dist[i][j] == 987654321) {
					System.out.print("0 ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}