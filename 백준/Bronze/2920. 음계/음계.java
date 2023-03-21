import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		for(int i = 0; i<8; i++) {
			arr[i] = sc.nextInt();
		}
		String res = "mixed";
		for(int i = 0; i<8; i++) {
			if(arr[i]!=i+1) {
				break;
			}
			if(i==7) {
				res = "ascending";
			}
		}
		for(int i = 0; i<8; i++) {
			if(arr[i]!=8-i) {
				break;
			}
			if(i==7) {
				res = "descending";
			}
		}
		System.out.println(res);
	}
}