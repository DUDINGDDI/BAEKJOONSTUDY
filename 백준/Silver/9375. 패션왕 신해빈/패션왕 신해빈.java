import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			HashMap<String, Integer> hm = new HashMap<>();
			int n = sc.nextInt();
			while (n-- > 0) {
				sc.next();
				String kind = sc.next();

				if (hm.containsKey(kind)) {
					hm.put(kind, hm.get(kind)+1);
				} else {
					hm.put(kind, 1);
				}
			}

			int result = 1;
			for (int x : hm.values()) {
				result *= (x + 1);
			}
			System.out.println(result - 1);
		}
	}
}