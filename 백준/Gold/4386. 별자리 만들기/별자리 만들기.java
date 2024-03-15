import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int index;
	double cost;
	
	public Edge(int index, double cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return (int) (this.cost - o.cost);
	}
}

public class Main {
	static int n;
	static ArrayList<Edge>[] graph;
	static double[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        graph = new ArrayList[n];
        arr = new double[n][2];
        for(int i = 0 ; i < n ; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < n ; i++) {
        	arr[i][0] = sc.nextDouble();
        	arr[i][1] = sc.nextDouble();
        	
        	for(int j = 0 ; j < i ; j++) {
        		graph[i].add(new Edge(j, Math.sqrt((arr[i][0]-arr[j][0])*(arr[i][0]-arr[j][0]) + (arr[i][1]-arr[j][1])*(arr[i][1]-arr[j][1]))));
        		graph[j].add(new Edge(i, Math.sqrt((arr[i][0]-arr[j][0])*(arr[i][0]-arr[j][0]) + (arr[i][1]-arr[j][1])*(arr[i][1]-arr[j][1]))));
        	}
        }
        
        prim(0);
        
    }
    
    public static void prim(int start) {
    	boolean[] visit = new boolean[n];
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.add(new Edge(start, 0));
    	
    	double sum = 0;
    	while(!pq.isEmpty()) {
    		Edge cur = pq.poll();
    		
    		if(visit[cur.index]) continue;
    		visit[cur.index] = true;
    		sum += cur.cost;
    		
    		for(Edge next : graph[cur.index]) {
    			if(!visit[next.index]) {
    				pq.add(next);
    			}
    		}
    	}
    	
    	System.out.println(sum);
    }
}