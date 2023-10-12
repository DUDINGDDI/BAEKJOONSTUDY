import java.util.Scanner;

public class Main {
	static int n;
	static int[][] board;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = sc.nextInt();
				board[i][j] = num;
				if (num > max) {
					max = num;
				}
			}
		}
		game(0);
		System.out.println(max);
	}

	public static void game(int count) {
		if (count == 5) {
			findMax();
			return;
		}
		int copy[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			copy[i] = board[i].clone();

		for (int i = 0; i < 4; i++) {
			move(i);
			game(count + 1);
			for (int a = 0; a < n; a++)
				board[a] = copy[a].clone();
		}
	}

	public static void move(int dir) {
		switch (dir) {
		case 0:
			for (int i = 0; i < n; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < n; j++) {
					if (board[j][i] != 0) {
						if (block == board[j][i]) {
							board[index - 1][i] = block * 2;
							block = 0;
							board[j][i] = 0;
						} else {
							block = board[j][i];
							board[j][i] = 0;
							board[index][i] = block;
							index++;
						}
					}
				}
			}
			break;
		// 왼쪽으로 몰기
		case 1:
			for (int i = 0; i < n; i++) {
				int index = n - 1;
				int block = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (board[j][i] != 0) {
						if (block == board[j][i]) {
							board[index + 1][i] = block * 2;
							block = 0;
							board[j][i] = 0;
						} else {
							block = board[j][i];
							board[j][i] = 0;
							board[index][i] = block;
							index--;
						}
					}
				}
			}
			break;
		// 왼쪽으로 몰기
		case 2:
			for (int i = 0; i < n; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < n; j++) {
					if (board[i][j] != 0) {
						if (block == board[i][j]) {
							board[i][index - 1] = block * 2;
							block = 0;
							board[i][j] = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][index] = block;
							index++;
						}
					}
				}
			}
			break;
		// 오른쪽으로 몰기
		case 3:
			for (int i = 0; i < n; i++) {
				int index = n - 1;
				int block = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (board[i][j] != 0) {
						if (block == board[i][j]) {
							board[i][index + 1] = block * 2;
							block = 0;
							board[i][j] = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		}
	}

	public static void findMax() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				max = Math.max(max, board[i][j]);
	}
}