import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int x = sc.nextInt();
		while (!(n==0&&x==0)) {
//		for(int i = 0; i<n; i++) {
//			int a = sc.nextInt();
//			if(a<x) {
//				sb.append(a).append(" ");
//			}
//		}
			sb.append(n + x).append("\n");
			n = sc.nextInt();
			x = sc.nextInt();
		}
		System.out.println(sb);
	}
}