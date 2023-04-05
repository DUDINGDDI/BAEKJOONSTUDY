import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] vis;
	static int n;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int e = sc.nextInt();
		vis = new boolean[n+1]; //방문 배열
		arr = new int[n + 1][n + 1];// 인접배열
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1; 
			arr[b][a] = 1; 
		}
		virus(1);
		System.out.println(cnt);
	}
	static void virus(int start) {
		vis[start] = true;
		for(int i = 1; i<=n; i++) {
			if(arr[start][i]==1&&!vis[i]) {
				cnt++;
				virus(i);
			}
		}
	}
}