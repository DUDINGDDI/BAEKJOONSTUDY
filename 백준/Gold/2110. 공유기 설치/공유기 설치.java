import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int min = 1;
		int max = arr[n-1]-arr[0]+1;
		
		while(min<max) {
			int mid = (min+max)/2;
			if(check(mid)<m) {	//공유기 갯수가 m 개보다 작으면 거리좁힘
				max = mid;
			}else {
				min = mid+1; //m개보다 크면 거리르 벌려 최소거리가 가질 최대거리 찾아내기
			}
				
		}
		System.out.println(min-1);
	}
	public static int check(int dis) {
		int cnt = 1;
		 int a = arr[0];	//첫집 설치하고
		 
		 for(int i = 1; i<arr.length; i++) {
			 int b = arr[i];
			 // 직전에 설치했던 집의 위치간 거리가 최소보다 크거나 같을때 공유기 설치
			 // 마지막 위치 갱신
			 if(b - a >= dis) {
				 cnt++;
				 a = b;
			 }
		 }
		 return cnt;
	}
}