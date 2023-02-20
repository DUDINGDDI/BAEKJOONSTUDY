import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		char[] arr = a.toCharArray();
		char[] po = { '(', ')' };
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == po[0] && arr[i + 1] == po[1]) {
				arr[i] = 'L';
				arr[i + 1] = ' ';
			}
		}
		Stack<Character> st = new Stack<>();
		int cnt = 0;
		int lp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				st.push(arr[i]);
			} else if (arr[i] == ')') {
				st.pop();
				lp++;
			} else if (arr[i] == 'L') {
				cnt += (st.size() + lp);
				lp = 0;
			}
		}
		cnt += (st.size() + lp);

		System.out.println(cnt);
	}
}