import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] c = sc.next().toCharArray();
		int cnt0 = 0;
		int cnt1 = 0;
		for(char a:c) {
			if(a=='0') {
				cnt0 ++;
			}
			if(a=='1') {
				cnt1 ++;
			}
		}
		for(int i = 0; i<cnt0/2; i++) {
			sb.append(0);
		}
		for(int i = 0; i<cnt1/2; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}
}