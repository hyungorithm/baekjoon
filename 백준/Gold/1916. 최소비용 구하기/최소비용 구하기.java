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
		return Integer.compare(this.cost, o.cost);
	}
}


public class Main {
	static int N, M, start, finish;
	static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	graph[a].add(new Node(b, c));
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());
        
        Dijkstra(start);
        
    }
    
    static void Dijkstra(int start) {
    	boolean[] check = new boolean[N+1];
    	int[] dist = new int[N+1];
    	int INF = Integer.MAX_VALUE;
    	
    	Arrays.fill(dist, INF);
    	dist[start] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start, 0));
    	
    	while(!pq.isEmpty()) {
    		int curV = pq.poll().index;
    		
    		if(curV == finish) {
    			break;
    		}
    		
    		if(check[curV]) continue;
    		check[curV] = true;
    		
    		for(Node next : graph[curV]) {
    			if(dist[next.index] > dist[curV] + next.cost) {
    				dist[next.index] = dist[curV] + next.cost;
    				pq.add(new Node(next.index, dist[next.index]));
    			}
    		}
    	}
    	
    	System.out.println(dist[finish]);
    }
    
}