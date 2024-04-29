import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visit;
	static Queue<Integer> que = new LinkedList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int safety;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < M ; i++) {
			int num = Integer.parseInt(st.nextToken());
			visit[num] = true;
			que.add(num);
		}
		
		BFS();
		
	}

	private static void BFS() {
		while(!que.isEmpty()) {
			safety++;
			int size = que.size();
			for(int i = 0 ; i < size ; i++) {
				int now = que.poll();
				int two = 1;
				while(true) {
					if(two > N) break;
					if((now & two) != 0) {
						if(!visit[now-two]) {
							que.add(now-two);
							visit[now-two] = true;
						}
					}
					else {
						if(now+two > N) {
							two *= 2;
							continue;
						}
						else if(!visit[now+two]) {
							que.add(now+two);
							visit[now+two] = true;
						}
					}
					two *= 2;
				}
			}
		}
		System.out.println(safety-1);
	}
}
