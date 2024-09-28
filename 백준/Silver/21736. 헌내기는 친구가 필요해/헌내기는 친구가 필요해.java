import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] vis;
	static char[][] board;
	static int n;
	static int m;
	static int cnt = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static class pair{
		int x;
		int y;
		
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		vis = new boolean[n][m];
		board = new char[n][m];
		int x = 0;
		int y = 0;
		for(int i = 0; i<n; i++) {
			String s = sc.next();
			s.split("");
			board[i] = s.toCharArray();
			for(int j = 0; j<m; j++) {
				if(board[i][j]=='I') {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x, y);
		
		if(cnt > 0) System.out.println(cnt);
		else System.out.println("TT");
	}
	
	public static void bfs(int x, int y) {
		 Queue<pair> q = new LinkedList<>();
		 q.add(new pair(x, y));
		 vis[x][y] = true;
		 
		 while(!q.isEmpty()) {
			 pair p = q.poll();
			 for(int i = 0; i<4; i++) {
				 int nx = p.x+dx[i];
				 int ny = p.y+dy[i];
				 
				 if(!out(nx, ny)||board[nx][ny]=='X'||vis[nx][ny]) {
					 continue;
				 }
				 if(board[nx][ny] == 'P') cnt ++;
				 
				 vis[nx][ny] = true;
				 
				 q.add(new pair(nx, ny));
			 }
		 }
	}
	
	public static boolean out(int x, int y) {
		if(x<0 || x >=n || y<0 || y>=m) {
			return false;
		}
		return true;
	}
}