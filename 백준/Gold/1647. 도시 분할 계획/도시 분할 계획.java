import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int index;
	int cost;
	
	public Edge(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	graph[a].add(new Edge(b, c));
        	graph[b].add(new Edge(a, c));
        }
        
        Prim(1);
    }
    
    static void Prim(int start) {
    	int max = 0;
    	boolean[] visit = new boolean[N+1];
    	int sum = 0;
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.add(new Edge(start, 0));
    	
    	while(!pq.isEmpty()) {
    		
    		Edge cur = pq.poll();
    		
    		if(visit[cur.index]) continue;
    		visit[cur.index] = true;
    		if(cur.cost > max) max = cur.cost;
    		sum += cur.cost;
    		
    		for(Edge next : graph[cur.index]) {
    			if(!visit[next.index])
    				pq.add(next);
    		}
    	}
    	System.out.println(sum - max);
    }
}