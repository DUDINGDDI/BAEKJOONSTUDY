import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.next().toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 'X') {
				if (i<a.length-3&&Ach(i)) {
					for (int j = 0; j < 4; j++) {
						a[i + j] = 'A';
					}
				} else if(i<a.length-1&&Bch(i)){
					for (int j = 0; j < 2; j++) {
						a[i + j] = 'B';
					}
				}
			}
		}
		for(int i =0; i<a.length; i++) {
			if(a[i]=='X') {
				System.out.println(-1);
				return;
			}
		}
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i]);
		}
	}

	static boolean Ach(int x) {
		for (int i = 0; i < 4; i++) {
			if (a[x + i] != 'X') {
				return false;
			}
		}
		return true;
	}

	static boolean Bch(int x) {
		for (int i = 0; i < 2; i++) {
			if (a[x + i] != 'X') {
				return false;
			}
		}
		return true;
	}
}