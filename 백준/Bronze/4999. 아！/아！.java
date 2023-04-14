import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String me = sc.next();
		String doc = sc.next();
		int m = 0;
		int d = 0;
		for(int i = 0; i<1000; i++) {
			if(me.charAt(i)=='h') {
				m=i;
				break;
			}
		}
		for(int i = 0; i<1000; i++) {
			if(doc.charAt(i)=='h') {
				d=i;
				break;
			}
		}
		if(m<d) {
			System.out.println("no");
		}else {
			System.out.println("go");
		}
	}
}