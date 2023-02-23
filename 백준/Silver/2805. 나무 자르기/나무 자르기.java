import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];		
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int min=0;
		int max=arr[N-1];
		
		while(min<=max) {
			long sum = 0;
			int middle=(min+max)/2;
			for(int j=0; j<N; j++) {
				if(arr[j]>middle) {
					sum+=arr[j]-middle;
				}
			}
			if(M<=sum) {
				min=middle+1;}
				else {max=middle-1;}
			
		}

	System.out.println(max);} }