import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, 1, -1 };
	static char[][] board;
	static int cnt;
	static ArrayList<Boolean> vis = new ArrayList<>();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = sc.next();
			board[i] = str.toCharArray();
		}
		int res = 0;
		char[][] copy = new char[12][6];
		int decide = 0;
		while (true) {
//			 1번 터트림
			decide = vis.size();
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (board[i][j] != '.') {
						for (int k = 0; k < 12; k++) {
							copy[k] = board[k].clone();
						}
						cnt = 0;
						pop(i, j, board[i][j], copy);
						if (cnt > 3) {
							for (int k = 0; k < 12; k++) {
								board[k] = copy[k].clone();
							}
							vis.add(true);
						}
//						System.out.println(cnt);
//						System.out.println(Arrays.deepToString(vis.toArray()));
					}
				}
			}
			down(board);
			
			
			// 터트리고 내리기
			if (vis.size()==0||vis.size()==decide) {
				break;
			}
//			System.out.println("한바꾸");
			res++;
			
		}

//		for (int i = 0; i < 12; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		System.out.println(res);
	}

	static void pop(int n, int m, char col, char[][] bd) {
		for (int i = 0; i < 4; i++) {
			int x = n + dc[i];
			int y = m + dr[i];
			if (check(x, y) && bd[x][y] == col) {
				cnt++;
				bd[x][y] = '.';
				pop(x, y, col, bd);
			}
		}
	}
	static void down(char[][] board) {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				if (board[j][i] == '.') {
					int k = j - 1;
					while (k >= 0) {
						if (board[k][i] != '.') {
							board[j][i] = board[k][i];
							board[k][i] = '.';
							break;
						}
						k--;
					}
				}
			}
		}
	}
	static boolean check(int x, int y) {
		if (x < 0 || x >= 12 || y < 0 || y >= 6) {
			return false;
		} else {
			return true;
		}
	}
}