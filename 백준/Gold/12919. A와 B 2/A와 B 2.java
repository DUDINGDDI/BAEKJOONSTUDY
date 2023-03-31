import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Character> st = new ArrayList<>();
	static ArrayList<Character> ed = new ArrayList<>();
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		for(char c : str) {
			st.add(c);
		}
		str = sc.next().toCharArray();
		for(char c : str) {
			ed.add(c);
		}
		bp();
		System.out.println(res);
	}
	static void bp() {
		if(st.equals(ed)) {
			res = 1;
			return;
		}
		if(st.size()==ed.size()) {
			return;
		}
		if(ed.get(ed.size()-1)=='A') {
			ed.remove(ed.size()-1);
			bp();
			ed.add('A');
		}
		if(ed.get(0)=='B') {
			Collections.reverse(ed);
			ed.remove(ed.size()-1);
			bp();
			ed.add('B');
			Collections.reverse(ed);
		}
	}
}