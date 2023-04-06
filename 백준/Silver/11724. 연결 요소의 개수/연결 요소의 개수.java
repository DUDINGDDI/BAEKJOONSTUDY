import java.util.Scanner;

public class Main {
	static boolean[] vis;
	static int[][] arr;
	static int v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		int e = sc.nextInt();
		vis = new boolean[v+1];
		arr = new int[v+1][v+1];
		for(int i = 0; i<e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		int cnt = 0;
		for(int i = 1; i<=v; i++) {
			if(!vis[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int a) {
		vis[a]=true;
		for(int i = 1; i<=v; i++) {
			if(arr[a][i]==1&&!vis[i]) {
				dfs(i);
			}
		}
	}
}