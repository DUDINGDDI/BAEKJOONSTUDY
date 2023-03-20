import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n<m) {
			System.out.println("<");
		}else if(n>m) {
			System.out.println(">");
		}else {
			System.out.println("==");
		}
	}
}