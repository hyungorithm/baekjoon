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
	static ArrayList<Node>[] reverse;
	static int[] ans;
	static int N, M, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        ans = new int[N+1];
        
        for(int i = 1 ; i <= N ; i++) {
        	graph[i] = new ArrayList<>();
        	reverse[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	
        	graph[A].add(new Node(B, C));
        	reverse[B].add(new Node(A, C));
        }
        
        Dijk(X);
        Dijk2(X);
        
        int max = 0;
        for(int i = 1 ; i <= N ; i++) {
        	if(ans[i] > max) {
        		max = ans[i];
        	}
        }
        System.out.println(max);
    }
    
    static void Dijk(int start) {
    	boolean[] check = new boolean[N+1];
    	
    	int[] dist = new int[N+1];
    	int INF = Integer.MAX_VALUE;
    	Arrays.fill(dist, INF);
    	dist[start] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start,0));
    	
    	while(!pq.isEmpty()) {
    		int cur = pq.poll().index;
    		
    		if(check[cur]) continue;
    		check[cur] = true;
    		
    		for(Node next : graph[cur]) {
    			if(dist[next.index] > dist[cur] + next.cost) {
    				dist[next.index] = dist[cur] + next.cost;
    				pq.add(new Node(next.index, dist[next.index]));
    			}
    		}
    	}
    	
    	for(int i = 1 ; i <= N ; i++) {
    		ans[i] += dist[i];
    	}
    }
    
    static void Dijk2(int start) {
    	boolean[] check = new boolean[N+1];
    	
    	int[] dist = new int[N+1];
    	int INF = Integer.MAX_VALUE;
    	Arrays.fill(dist, INF);
    	dist[start] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start,0));
    	
    	while(!pq.isEmpty()) {
    		int cur = pq.poll().index;
    		
    		if(check[cur]) continue;
    		check[cur] = true;
    		
    		for(Node next : reverse[cur]) {
    			if(dist[next.index] > dist[cur] + next.cost) {
    				dist[next.index] = dist[cur] + next.cost;
    				pq.add(new Node(next.index, dist[next.index]));
    			}
    		}
    	}
    	
    	for(int i = 1 ; i <= N ; i++) {
    		ans[i] += dist[i];
    	}
    }
}