import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//48 57
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		char[] arr = a.toCharArray(); // 받은 문자열
		ArrayList<Character> back = new ArrayList<>(); // 후위
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 65 && arr[i] <= 90) {
				back.add(arr[i]);
			} else if (arr[i] == '(') {
				st.push(arr[i]);
			} else if (arr[i] == '*' || arr[i] == '/') {
				while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
					back.add(st.pop());
				}
				st.push(arr[i]);
			} else if (arr[i] == '+' || arr[i] == '-') {
				while (!st.isEmpty()
						&& (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/')) {
					back.add(st.pop());
				}
				st.push(arr[i]);
			} else if (arr[i] == ')') {
				while (true) {
					if (st.peek() == '(') {
						st.pop();
						break;
					}
					back.add(st.pop());
				}
			}
		}
		while (!st.isEmpty()) {
			back.add(st.pop());
		}
		for(int i = 0; i<back.size();i++) {
			System.out.print(back.get(i));
		}
	}
}