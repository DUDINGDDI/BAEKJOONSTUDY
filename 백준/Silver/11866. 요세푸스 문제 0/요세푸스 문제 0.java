import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i = 1; i<=a; i++) {
			q.offer(i);
		}
		sb.append("<");
		
		while(!q.isEmpty()) {
			for(int i = 1; i<b; i++) {				
				q.offer(q.poll());
			}
			sb.append(q.poll());
			if(!q.isEmpty()) sb.append(", ");
			else sb.append(">");
		}
		System.out.println(sb);
		
	}
	
}