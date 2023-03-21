import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			int a = sc.nextInt();
			if(a<x) {
				sb.append(a).append(" ");
			}
		}
		System.out.println(sb);
	}
}