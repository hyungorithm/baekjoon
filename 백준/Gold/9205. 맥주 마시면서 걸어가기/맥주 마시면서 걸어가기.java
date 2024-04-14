import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int homer, homec;
	static int[] map;
	static boolean[] visit;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int ti = 0 ; ti < t ; ti++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N*2+2];
			visit = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			que.add(Integer.parseInt(st.nextToken()));
			que.add(Integer.parseInt(st.nextToken()));
			
			for(int i = 0 ; i < N+1 ; i++) {
				st = new StringTokenizer(br.readLine());
				map[i*2] = Integer.parseInt(st.nextToken());
				map[i*2+1] = Integer.parseInt(st.nextToken());
			}
			
			while(!que.isEmpty()) {
				int r = que.poll();
				int c = que.poll();
				for(int i = 0 ; i < N+1 ; i++) {
					if(!visit[i] && Math.abs(r - map[i*2]) + Math.abs(c - map[i*2+1]) <= 1000) {
						que.add(map[i*2]);
						que.add(map[i*2+1]);
						visit[i] = true;
					}
				}
			}
			
			if(visit[N]) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
