import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int index;
	int cost;
	
	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Node>[] graph;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new ArrayList[Math.max(N+1,K*2)];
		
		for(int i = 0 ; i < Math.max(N+1,K*2) ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		Dijk();
	}
	
	public static void Dijk() {
		boolean[] check = new boolean[Math.max(N+1,K*2)];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(N, 0));
		
		int[] dist = new int[Math.max(N+1,K*2)];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.index == K) {
				System.out.println(dist[now.index]);
				return;
			}
			
			if(check[now.index]) continue;
			check[now.index] = true;
			
			if(now.index-1 >= 0) {
				if(dist[now.index-1] > dist[now.index] + 1) {
					dist[now.index-1] = dist[now.index] + 1;
					pq.add(new Node(now.index-1, dist[now.index] + 1));
				}
			}
			if(now.index+1 < Math.max(N+1,K*2)) {
				if(dist[now.index+1] > dist[now.index] + 1) {
					dist[now.index+1] = dist[now.index] + 1;
					pq.add(new Node(now.index+1, dist[now.index] + 1));
				}
			}
			if(now.index*2 < Math.max(N+1,K*2)) {
				if(dist[now.index*2] > dist[now.index]) {
					dist[now.index*2] = dist[now.index];
					pq.add(new Node(now.index*2, dist[now.index]));
				}
			}
		}
		
		
	}
}
