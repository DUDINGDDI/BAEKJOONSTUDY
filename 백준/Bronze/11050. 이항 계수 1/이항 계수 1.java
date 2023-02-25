import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int c = mul(a,b);
		int d = mul(b,b);
		System.out.println(c/d);
	}
	public static int mul(int a, int b) {
		int num = 1;
		for(int i = 0; i<b; i++) {
			num*=a--;
		}
		return num;
	}
}