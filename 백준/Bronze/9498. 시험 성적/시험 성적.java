import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n>=90) {
			System.out.println("A");
			return;
		}else if(n>=80) {
			System.out.println("B");
			return;
		}else if(n>=70) {
			System.out.println("C");
			return;
		}else if(n>=60) {
			System.out.println("D");
			return;
		}else {
			System.out.println("F");
			return;
		}
	}
}