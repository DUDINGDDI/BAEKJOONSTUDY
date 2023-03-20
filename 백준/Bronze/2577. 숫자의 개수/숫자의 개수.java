import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[10];

		int n = a * b * c;
		String str = "";
		str += n;
		char[] ar = str.toCharArray();
		for (char aa : ar) {
			arr[(int) (aa - 48)]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}