import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		String str = sc.next();
		char[] arr = str.toCharArray();
		int sum = 0;
		for(int i = 0; i<tc; i++) { //96
			sum += (arr[i]-96)*Math.pow(31, i);
		}
		System.out.println(sum);
	}
}