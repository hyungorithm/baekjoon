import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int w;
	int cost;
	
	Edge(int w, int cost) {
		this.w = w;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Edge>[] graph;
	
	static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i++) {
        	graph[i] = new ArrayList<>();
        }
        		
        for(int i = 0 ; i < E ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	
        	graph[A].add(new Edge(B, C));
        	graph[B].add(new Edge(A, C));
        }
        prim(1);
    }
    
    
    
    public static void prim(int start) {
    	boolean[] visit = new boolean[V+1];
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.add(new Edge(start, 0));
    	
    	int total = 0;
    	while(!pq.isEmpty()) {
    		Edge edge = pq.poll();
    		int v = edge.w;
    		int cost = edge.cost;
    		
    		if(visit[v]) continue;
    		visit[v] = true;
    		
    		total += cost;
    		
    		for(Edge e : graph[v]) {
    			if(!visit[e.w]) {
    				pq.add(e);
    			}
    		}	
    	}
    	
    	System.out.println(total);
    }
}