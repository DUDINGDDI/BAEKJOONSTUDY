import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] arr = a.split(" ");
		if (arr.length!=0&&arr[0].equals("")) {
			System.out.println(arr.length - 1);
		} else {
			System.out.println(arr.length);
		}
	}
}