import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class pair{
		int x, y, z;
		public pair(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static int num;
	static int n, m, h;
	static int[][][] arr;
	static int[] dc = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		arr = new int[h][m][n];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					arr[i][j][k] = sc.nextInt();
				}
			}
		}
		
		
		Queue<pair> q = new LinkedList<pair>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if(arr[i][j][k]==1) {
						q.add(new pair(i, j, k));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			pair a = q.poll();
			
			for(int i = 0; i<6; i++) {
				int x = a.x+dr[i];	//층수
				int y = a.y+dc[i];	//가로
				int z = a.z+dh[i];	//세로
				if(check(y, z, x)&&arr[x][y][z]==0) {
					arr[x][y][z]=arr[a.x][a.y][a.z]+1;
					num = Math.max(arr[x][y][z], num);
					q.add(new pair(x, y, z));
				}
			}
		}
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<m; j++) {
				for(int k = 0; k<n; k++) {
					if(arr[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		if(num==0) {
			System.out.println(0);
			return;
		}
		System.out.println(num-1);
	}

	
	
	
	static boolean check(int x, int y, int z) {
		if (x < 0 || y < 0 || z < 0 || x >= m || y >= n || z >= h) {
			return false;
		} else {
			return true;
		}
	}
}