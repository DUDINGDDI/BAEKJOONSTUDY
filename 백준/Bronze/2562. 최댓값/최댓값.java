import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int[] arr2 = new int[9];
		for(int i = 0; i<9; i++) {
			int a = sc.nextInt();
			arr2[i] = a;
			arr[i] = a;
		}
		Arrays.sort(arr);
		for(int i = 0; i<9; i++) {
			if(arr[8]==arr2[i]) {
				System.out.println(arr[8]);
				System.out.println(i+1);
			}
		}
//		System.out.println("Hello World!");
	}
}