import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		String str = sc.next();
		char[] ch = str.toCharArray();
		int cnt = 0;
		int res = 0;
		for (int i = 1; i < (s - 1); i++) {
			if (ch[i - 1] == 'I' && ch[i] == 'O' && ch[i + 1] == 'I') {
				cnt++;
				if (cnt == n) {
					cnt--;
					res++;
				}
				i++;
			}else {
				cnt = 0;
			}
		}
		System.out.println(res);
	}
}