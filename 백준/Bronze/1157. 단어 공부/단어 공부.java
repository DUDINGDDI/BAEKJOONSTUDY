import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine().toUpperCase();
		char[] arr = a.toCharArray();
		int[] cnt = new int[26];
//		char b = 'Z'-65;
		for(char n : arr) {
			cnt[(int)(n-65)]++;
		}
		int max = 0;
		int res = 0;
		for(int i = 0; i<26; i++) {
			if(cnt[i]>0) {
				if(max<cnt[i]) {
					max = cnt[i];
					res = i;
				}
			}
		}
		Arrays.sort(cnt);
		if(cnt[25]==cnt[24]) {
			System.out.println("?");
			return;
		}
		System.out.println((char)(res+65));
	}
}