import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Pair implements Comparable<Pair>{
		int start;
		int end;

		Pair(int x, int y) {
			this.start = x;
			this.end = y;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}

	}

	public static void main(String[] args) throws Exception, IOException {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) {// 강의정보 다넣기
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			p[i] = new Pair(start, end);
		}
		Arrays.sort(p);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(p[0].end);
		
		for(int i = 1; i<n; i++) {
			if(pq.peek() <= p[i].start) {
				pq.poll();
			}
			pq.offer(p[i].end);
		}
		System.out.println(pq.size());
	}
}