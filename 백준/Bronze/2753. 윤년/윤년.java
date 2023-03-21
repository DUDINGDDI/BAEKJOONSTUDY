import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int res = 0;
		if(n%400==0) {
			res = 1;
		}else if(n%4==0) {
			if(n%100!=0) {
				res = 1;
			}
		}
		System.out.println(res);
	}
}