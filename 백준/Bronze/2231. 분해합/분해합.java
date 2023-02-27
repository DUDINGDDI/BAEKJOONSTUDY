
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int re = 0;
		for(int i = n; i>0;i--) {
			int res = i;
			int b = i;
			while(true) {
				int a = b%10;
				b = b/10;
				res += a;
				if(b==0) break;
			}
			if(res == n) {
				re = i;				
			}
		}
		System.out.println(re);
	}
}