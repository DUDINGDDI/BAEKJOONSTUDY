import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int a = sc.nextInt();
		
		for(int i = 0; i<a; i++) {
			int b = sc.nextInt();
			sb.append(upperBound(arr, b)-lowerBound(arr, b)).append(" ");
			
		}
		System.out.println(sb);

		
		
		
		
	}
	public static int lowerBound(int[] data, int target) {
		int begin = 0;
		int end = data.length;
		
		while(begin < end) {
			int mid = (begin + end) / 2;
			
			if(data[mid] >= target) {
				end = mid;
			}
			else {
				begin = mid + 1;
			}
		}
		return begin;
	}
	
	private static int upperBound(int[] data, int target) {
	    int begin = 0;
	    int end = data.length;
	    
	    while(begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(data[mid] <= target) {
	        	begin = mid + 1;
	        }
	        else {
	        	end = mid;
	        }
	    }
	    return end;
	}
}