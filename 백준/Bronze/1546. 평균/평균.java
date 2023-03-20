import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		double sum = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		sum=sum/(double)(arr[n-1])*100;
		System.out.println(sum/n);
	}
}