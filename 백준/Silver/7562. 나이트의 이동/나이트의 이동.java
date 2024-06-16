import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L, sr, sc, er, ec, cnt;
	static Queue<Integer> que = new LinkedList<>();
	static boolean[][] visit;
	static int[] dr = {-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {1,2,2,1,-1,-2,-2,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int ti = 0 ; ti < t ; ti++) {
			L = Integer.parseInt(br.readLine());
			visit = new boolean[L][L];
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			que.clear();
			que.add(sr);
			que.add(sc);
			visit[sr][sc] = true;
			
			cnt = 0;
			bfs();
			
		}
		
		
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			if(visit[er][ec]) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			int size = que.size() / 2;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0 ; d < 8 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < L && c+dc[d] >= 0 && c+dc[d] < L && !visit[r+dr[d]][c+dc[d]]) {
						que.add(r+dr[d]);
						que.add(c+dc[d]);
						visit[r+dr[d]][c+dc[d]] = true;
					}
				}
			}
		}
	}
}
