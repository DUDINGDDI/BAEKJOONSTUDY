import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		int a = sum-100;
		m:for(int i = 0; i<8; i++) {
			for(int j = i+1; j<9; j++) {
				if((arr[i]+arr[j])==a) {
					arr[i]=0;
					arr[j]=0;
					break m;
				}
			}
		}
		Arrays.sort(arr);
		for(int i =2; i<9; i++) {
			System.out.println(arr[i]);
		}
	}
}