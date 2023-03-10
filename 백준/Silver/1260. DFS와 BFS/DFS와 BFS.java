import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	static boolean[] vi;
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int s = sc.nextInt();
		vi = new boolean[n+1];
		graph = new int[n+1][n+1];
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph [b][a] = 1;
		}
		
		dfs(s);
		vi = new boolean[n+1];
		sb.append("\n");
		bfs(s);
		
		System.out.println(sb);
		
	}
	static void dfs(int i) {
		vi[i] = true;
		sb.append(i).append(" ");
		
		for(int j =1; j<=n; j++) {
			if(graph[i][j]==1&&vi[j]==false) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		vi[i] = true;
		sb.append(i).append(" ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int j = 1; j<=n; j++) {
				if(graph[temp][j] ==1&&vi[j]==false) {
					q.offer(j);
					vi[j]=true;
					sb.append(j).append(" ");
					
				}
			}
		}
	}
}