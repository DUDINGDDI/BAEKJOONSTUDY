import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] n =sc.next().toCharArray();
		char[] m =sc.next().toCharArray();
		
		String a = "";
		String b = "";
		for(int i = 0; i<n.length; i++) {
			a+=n[n.length-1-i];
		}
		for(int i = 0; i<m.length; i++) {
			b+=m[m.length-1-i];
		}
		int max = Math.max(Integer.parseInt(a),Integer.parseInt(b));
		System.out.println(max);
	}
}