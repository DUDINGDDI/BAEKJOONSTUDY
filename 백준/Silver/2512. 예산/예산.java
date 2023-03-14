import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int[] arr = new int[n];	//돈 배열에 저장
		 int sum = 0;
		 for(int i = 0; i<n; i++) {
			 arr[i] = sc.nextInt();
			 sum += arr[i];
		 }
		 Arrays.sort(arr);
		 int max = sc.nextInt();	//최대 예산
		 if(sum <= max) {
			 System.out.println(arr[n-1]);
			 return;
		 }
		 int start = 0;
		 int end = arr[n-1];
		 int mid = 0;
		 while(sum!=max) {
			 sum = 0;
			 mid = (start+end)/2;
			 if(start == mid|| end==mid) {
				 break;
			 }
			 for(int i = 0; i<n; i++) {
				 if(arr[i]>=mid) {
					 sum += mid;
				 }else {
					 sum += arr[i];
				 }
			 }
//			 System.out.println(sum);
			 if(sum < max) {
				 start = mid;
				 mid += 1;
			 }else if(sum > max) {
				 end = mid;
			 }
		 }
		 System.out.println(mid);
	}
}