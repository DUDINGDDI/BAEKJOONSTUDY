import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] op = new int[4];
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i =0 ; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i =0 ; i<4; i++) {
			op[i] = sc.nextInt();
		}
		operator(0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static void operator(int idx, int res) {
		
		
		if(op[0]>0) {
			op[0]--;
			operator(idx+1, res + arr[idx+1]);
			op[0]++;
		}
		if(op[1]>0) {
			op[1]--;
			operator(idx+1, res - arr[idx+1]);
			op[1]++;
		}
		if(op[2]>0) {
			op[2]--;
			operator(idx+1, res * arr[idx+1]);
			op[2]++;
		}
		if(op[3]>0) {
			op[3]--;
			operator(idx+1, res / arr[idx+1]);
			op[3]++;
		}
		
		if(idx==n-1) {
			max = Math.max(res, max);
			min = Math.min(res, min);
			return;
		}
	}
}