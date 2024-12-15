import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int[][][] visit;
	static int N;
	static int[][] graph;
	static Queue<Integer> que = new LinkedList<>();
	static int min = 99999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		visit = new int[N][N][4];
		
		for(int r = 0 ; r < N ; r++) {
			String str = br.readLine();
			for(int c = 0  ; c < N ; c++) {
				visit[r][c][0] = 99999999;
				visit[r][c][1] = 99999999;
				visit[r][c][2] = 99999999;
				visit[r][c][3] = 99999999;
				graph[r][c] = str.charAt(c);
				if(graph[r][c] == '#') {
					if(que.isEmpty()) {
						que.add(r); que.add(c); que.add(0); que.add(0);
						que.add(r); que.add(c); que.add(1); que.add(0);
						que.add(r); que.add(c); que.add(2); que.add(0);
						que.add(r); que.add(c); que.add(3); que.add(0);
						visit[r][c][0] = 0;
						visit[r][c][1] = 0;
						visit[r][c][2] = 0;
						visit[r][c][3] = 0;
					}
				}
			}
		}
		
		BFS();
		System.out.println(min);
		
	}

	private static void BFS() {
		while(!que.isEmpty()) {
			int size = que.size()/4;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				int d = que.poll();
				int cnt = que.poll();
				if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && cnt < visit[r+dr[d]][c+dc[d]][d]) {
					if(graph[r+dr[d]][c+dc[d]] == '.') {
						que.add(r+dr[d]); que.add(c+dc[d]); que.add(d); que.add(cnt);
						visit[r+dr[d]][c+dc[d]][d] = cnt;
					}
					else if(graph[r+dr[d]][c+dc[d]] == '!') {
						que.add(r+dr[d]); que.add(c+dc[d]); que.add(d); que.add(cnt);
						que.add(r+dr[d]); que.add(c+dc[d]); que.add((d+1)%4); que.add(cnt+1);
						que.add(r+dr[d]); que.add(c+dc[d]); que.add((d+3)%4); que.add(cnt+1);
						visit[r+dr[d]][c+dc[d]][d] = cnt;
						visit[r+dr[d]][c+dc[d]][(d+1)%4] = cnt+1;
						visit[r+dr[d]][c+dc[d]][(d+3)%4] = cnt+1;
					}
					else if(graph[r+dr[d]][c+dc[d]] == '#') {
						if(cnt < min) min = cnt;
					}
				}
			}
		}
	}
}