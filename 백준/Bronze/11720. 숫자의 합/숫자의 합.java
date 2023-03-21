import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		int sum = 0;
		for(char c:arr) {
			sum += (int)(c-48);
		}
		System.out.println(sum);
	}
}