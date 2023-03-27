import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int s = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int a;
			switch (str) {
			case "add":
				a = sc.nextInt();
				s = s | (1 << a);
				break;
			case "remove":
				a = sc.nextInt();
				s = s & ~(1 << a);
				break;
			case "check":
				a = sc.nextInt();
				int temp = s & (1 << a);
				sb.append(((temp == 0) ? 0 : 1) + "\n");
				break;
			case "toggle":
				a = sc.nextInt();
				s = s ^ (1 << a);
				break;
			case "all":
				s = (1 << 21) - 1;
				break;
			case "empty":
				s = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}