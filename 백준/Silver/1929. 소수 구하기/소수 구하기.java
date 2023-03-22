import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		ArrayList<Boolean> check = new ArrayList<>(n+1);
		check.add(false);
		check.add(false);
		
		for(int i = 2; i<=n; i++) {
			check.add(i, true);
		}
		
		for(int i = 2; i*i<=n; i++) {
			if(check.get(i)) {
				for(int j = 2; i*j<=n; j++) {
					check.set(i*j, false);
				}
			}
		}
		
		for(int i = m; i<=n; i++) {
			if(check.get(i)) {
				System.out.println(i);
			}
		}
	}
}