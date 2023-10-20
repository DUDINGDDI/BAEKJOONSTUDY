import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		String str = sc.next();
		char[] ch = str.toCharArray();
		int cnt = 0;
		int size = 2 * n + 1;
		m: for (int i = 0; i < (s - size+1); i++) {
			for (int j = 0; j < size; j++) {
				if ((j % 2 == 0 && ch[i + j] == 'O') || (j % 2 == 1 && ch[i + j] == 'I')) {
					continue m;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}