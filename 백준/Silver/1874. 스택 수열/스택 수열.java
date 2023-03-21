import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		int in = 1;
//		while (x < n) {
		for (int x = 0; x < n; x++) {
			if (st.isEmpty()) {
				sb.append("+\n");
				st.push(in);
				in++;
			}
			if (st.peek() < arr[x]) {
				while (st.peek() < arr[x]) {
					sb.append("+\n");
					st.push(in);
					in++;
				}
			}
			if (st.peek() == arr[x]) {
				sb.append("-\n");
				st.pop();
			}
		}
		if (st.isEmpty())
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}