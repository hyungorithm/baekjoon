import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] degree = new int[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int mi = 0 ; mi < M ; mi++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			
			int tmp1, tmp2;
			tmp2 = Integer.parseInt(st.nextToken());
			
			for(int i = 1 ; i < S ; i++) {
				tmp1 = tmp2;
				tmp2 = Integer.parseInt(st.nextToken());
				graph[tmp1].add(tmp2);
				degree[tmp2]++;
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			if(degree[i]==0) que.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now+"\n");
			cnt++;
			for(int e : graph[now]) {
				degree[e]--;
				if(degree[e]==0) que.add(e);
			}
		}
		
		if(cnt != N) {
			System.out.println(0);
			return;
		}
		System.out.println(sb);
	}
}