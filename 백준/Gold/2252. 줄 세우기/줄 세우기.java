import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] degree;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        degree = new int[N+1];
        graph = new ArrayList[N+1];
        
        for(int i = 1 ; i <= N ; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	graph[s].add(e);
        	degree[e]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i <= N ; i++) {
        	if(degree[i]==0) que.add(i);
        }
        
        while(!que.isEmpty()) {
        	int now = que.poll();
        	sb.append(now+" ");
        	for(int i : graph[now]) {
        		degree[i]--;
        		if(degree[i]==0) que.add(i);
        	}
        }
        System.out.println(sb);
    }
}