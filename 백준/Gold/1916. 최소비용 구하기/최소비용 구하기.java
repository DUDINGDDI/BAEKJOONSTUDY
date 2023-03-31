import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node {
		int next, cost;

		Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}

	static class PqFormat implements Comparable<PqFormat> {
		int idx, dist;

		PqFormat(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(PqFormat o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		ArrayList<Node>[] connections = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			connections[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			connections[x].add(new Node(y,z));
//			connections[y].add(new Node(x,z));
		}
		int start = sc.nextInt();
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		boolean[] visited = new boolean[n+1];
		
		PriorityQueue<PqFormat> pq = new PriorityQueue<>();
		pq.add(new PqFormat(start, 0));
		
		while(!pq.isEmpty()) {
			PqFormat now = pq.poll();
			if(visited[now.idx]==true) continue;
			
			visited[now.idx] = true;
			for(Node node : connections[now.idx]) {
				if(dist[node.next]>dist[now.idx] + node.cost) {
					dist[node.next] = dist[now.idx]+node.cost;
					pq.add(new PqFormat(node.next, dist[node.next]));
				}
			}
		}
		
		System.out.println(dist[sc.nextInt()]);
	}
}