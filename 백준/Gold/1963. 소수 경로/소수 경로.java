import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static boolean[] isComp = new boolean[10000];
	static boolean[] visit;
	static int start, end;
	static int cnt = 0;
	static Queue<Integer> que = new LinkedList<>();
	static boolean able;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		loop:
		for(int r = 2 ; r <= 100 ; r++) {
			if(isComp[r]) continue;
			for(int c = 2 ; c <= 5000 ; c++) {
				if(r*c > 9999) continue loop;
				isComp[r*c] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int ti = 0 ; ti < T ; ti++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if(start == end) {
				System.out.println(0);
				continue;
			}
			
			visit = new boolean[10000];
			que.clear();
			able = false;
			
			que.add(start);
			visit[start] = true;
			
			cnt = 0;
			BFS();
			if(able) {
				System.out.println(cnt);				
			}
			else {
				System.out.println("Impossible");
			}
		}
		
	}

	private static void BFS() {
		while(!que.isEmpty()) {
			int size = que.size();
			cnt++;
			for(int i = 0 ; i < size ; i++) {
				int now = que.poll();
				for(int d = 0 ; d < 10 ; d++) {
					int next1 = (now/1000)*1000 + ((now/100)%10)*100 + ((now/10)%10)*10 + d;
					int next2 = (now/1000)*1000 + ((now/100)%10)*100 + d*10 + now%10;
					int next3 = (now/1000)*1000 + d*100 + ((now/10)%10)*10 + now%10;
					
					if(next1 == end || next2 == end || next3 == end) {
						able = true;
						return;
					}
					
					if(!visit[next1] && !isComp[next1]) {
						visit[next1] = true;
						que.add(next1);
					}
					
					if(!visit[next2] && !isComp[next2]) {
						visit[next2] = true;
						que.add(next2);
					}
					
					if(!visit[next3] && !isComp[next3]) {
						visit[next3] = true;
						que.add(next3);
					}
					
					if(d == 0) continue;
					
					int next4 = d*1000 + ((now/100)%10)*100 + ((now/10)%10)*10 + now%10;
					
					if(next4 == end) {
						able = true;
						return;
					}
					
					if(!visit[next4] && !isComp[next4]) {
						visit[next4] = true;
						que.add(next4);
					}
				}
			}
		}
	}
	
	
}