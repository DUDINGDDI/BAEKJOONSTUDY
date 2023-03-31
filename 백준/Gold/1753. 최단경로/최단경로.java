import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node{
		int next, cost;
		Node(int next, int cost){
			this.next = next;
			this.cost = cost;
		}
	}
	static class Pq implements Comparable<Pq>{
		int idx, dist;
		Pq(int idx, int dist){
			this.idx = idx;
			this.dist = dist;
		
		}
		@Override
		public int compareTo(Pq o) {
			return this.dist-o.dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int start = sc.nextInt();
		ArrayList<Node>[] con = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			con[i] = new ArrayList<>();
		}
		for(int i = 0; i<e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			
			con[x].add(new Node(y, w));
		}
		int dist[] = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		boolean[] vis = new boolean[n+1];
		
		PriorityQueue<Pq> pq = new PriorityQueue<>();
		pq.add(new Pq(start, 0));
		
		while(!pq.isEmpty()) {
			Pq now = pq.poll();
			if(vis[now.idx]==true) continue;
			
			vis[now.idx] = true;
			for(Node node : con[now.idx]) {
				if(dist[node.next]>dist[now.idx]+node.cost) {
					dist[node.next] = dist[now.idx]+node.cost;
					pq.add(new Pq(node.next, dist[node.next]));
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
	}
}