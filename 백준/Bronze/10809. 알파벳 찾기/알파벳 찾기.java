import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] arr = sc.next().toCharArray();
		int[] res = new int[26];
		for(int i = 0; i<26; i++) {
			res[i] = -1;
		}
		for(int i = 0; i<arr.length; i++) {
			if(res[(int)(arr[i]-97)]==-1){
				res[(int)(arr[i]-97)]=i;
			}
		}
		for(int a:res) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}