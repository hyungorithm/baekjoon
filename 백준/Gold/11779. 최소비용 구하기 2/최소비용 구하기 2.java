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
		super();
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	public static ArrayList<Node>[] graph;
	public static int n, m, start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		for(int i = 1 ; i <= n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijk();
		
	}
	
	public static void dijk() {
		boolean[] visit = new boolean[n+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		int[] dist = new int[n+1];
		String[] str = new String[n+1];
		int[] cnt = new int[n+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(str, "");
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.index == end) break;
			
			if(visit[now.index]) continue;
			visit[now.index] = true;
			
			for(Node next : graph[now.index]) {
				if(dist[now.index] + next.cost < dist[next.index]) {
					dist[next.index] = dist[now.index] + next.cost;
					str[next.index] = str[now.index] + " " + next.index;
					cnt[next.index] = cnt[now.index] + 1;
					pq.add(new Node(next.index, dist[now.index] + next.cost));
				}
			}
		}
		System.out.println(dist[end]);
		System.out.println(1+cnt[end]);
		System.out.println(start+str[end]);
	}
}
