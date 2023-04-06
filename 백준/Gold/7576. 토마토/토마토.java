import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class pair{
		int x, y;
		pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	static int max = 0;
	static int n;
	static int m;
	static int[][] arr;
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		bfs();
		
		m:for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, arr[i][j]);
				if(arr[i][j]==0) {
					max = 0;
					break m;
				}
			}
		}
		System.out.println(max-1);
	} // main
	static void bfs() {
		Queue<pair> q = new LinkedList<pair>();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j]==1) {
					q.add(new pair(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			pair a = q.poll();
			for(int k = 0; k<4; k++) {
				int x = a.x+dc[k];
				int y = a.y+dr[k];
				if(check(x,y)&&arr[x][y]==0) {
					arr[x][y] = arr[a.x][a.y]+1;
					q.add(new pair(x, y));
				}
			}
		}
	}
	
	
	static boolean check(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		} else {
			return true;
		}
	}// check
}