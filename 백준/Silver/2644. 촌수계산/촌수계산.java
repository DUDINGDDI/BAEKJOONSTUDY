import java.util.Scanner;

public class Main {
	static boolean[] vi;
	static int[][] graph;
	static int n;
	static int e;
	static int[] arr;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		int s = sc.nextInt();
		e = sc.nextInt();
		int m = sc.nextInt();
		vi = new boolean[n+1];
		arr = new int[n+1];
		graph = new int[n+1][n+1];
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph [b][a] = 1;
		}
		
		dfs(s);
		if(cnt==1) {
			System.out.println(-1);
		}
	}
	static void dfs(int i) {
		if(i==e) {
			System.out.println(cnt);
			return;
		}
		vi[i] = true;
		arr[i]= cnt++;
		
		for(int j =1; j<=n; j++) {
			if(graph[i][j]==1&&vi[j]==false) {
				dfs(j);
				cnt--;
			}
		}
	}
	
}