import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//Conparable
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pair> pair = new ArrayList<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			String b = sc.next();
			pair.add(new Pair(a, b));
		}
		MyComparator mc = new MyComparator();
		Collections.sort(pair, mc);
		for (int i = 0; i < n; i++) {
			System.out.println(pair.get(i).age+" "+pair.get(i).name);
		}
	}

}

class Pair {
	Pair(int age, String name) {
		this.age = age;
		this.name = name;
	}

	int age;
	String name;
}

class MyComparator implements Comparator<Pair> {
	@Override
	public int compare(Pair p1, Pair p2) {
		if (p1.age > p2.age) {
			return 1; // x에 대해서는 오름차순
		} else if (p1.age == p2.age) {
			return 0; // y에 대해서는 내림차순
		}

		return -1;
	}
}