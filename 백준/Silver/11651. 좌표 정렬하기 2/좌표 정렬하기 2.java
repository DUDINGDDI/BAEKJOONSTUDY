import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//Conparable
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<PairX> pair = new ArrayList<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pair.add(new PairX(b, a));
		}
		MyComparatorX mc = new MyComparatorX();
		Collections.sort(pair, mc);
		for (int i = 0; i < n; i++) {
			System.out.println(pair.get(i).y+" "+pair.get(i).age);
		}
	}

}

class PairX {
	PairX(int age, int y) {
		this.age = age;
		this.y = y;
	}

	int age;
	int y;
}

class MyComparatorX implements
Comparator<PairX> {
	@Override
	public int compare(PairX p1, PairX p2) {
		if (p1.age > p2.age) {
			return 1; // x에 대해서는 오름차순
		} else if (p1.age == p2.age) {
			if(p1.y>p2.y)
				return 1;// y에 대해서는 내림차순
		}

		return -1;
	}
}