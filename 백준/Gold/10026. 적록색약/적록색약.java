import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int N;
	static int[][] graph;
	static boolean[][] visit1;
	static boolean[][] visit2;
	static int cnt1 = 0;
	static int cnt2 = 0;
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];
		
		for(int r = 0 ; r < N ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < N ; c++) {
				if(str.charAt(c) == 'R')
					graph[r][c] = 1;
				else if(str.charAt(c) == 'B')
					graph[r][c] = 2;
				else if(str.charAt(c) == 'G')
					graph[r][c] = 3;
			}
		}
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				if(!visit1[r][c]) {
					cnt1++;
					que.add(r);
					que.add(c);
					visit1[r][c] = true;
					BFS1();
				}
				if(!visit2[r][c]) {
					cnt2++;
					que.add(r);
					que.add(c);
					visit2[r][c] = true;
					BFS2();
				}
			}
		}
		
		System.out.println(cnt1+" "+cnt2);
	}

	private static void BFS1() {
		while(!que.isEmpty()) {			
			int size = que.size()/2;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && !visit1[r+dr[d]][c+dc[d]] && graph[r][c] == graph[r+dr[d]][c+dc[d]]) {
						visit1[r+dr[d]][c+dc[d]] = true;
						que.add(r+dr[d]);
						que.add(c+dc[d]);
					}
				}
			}
		}
	}
	
	private static void BFS2() {
		while(!que.isEmpty()) {			
			int size = que.size()/2;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && !visit2[r+dr[d]][c+dc[d]] && graph[r][c]%2 == graph[r+dr[d]][c+dc[d]]%2) {
						visit2[r+dr[d]][c+dc[d]] = true;
						que.add(r+dr[d]);
						que.add(c+dc[d]);
					}
				}
			}
		}
	}
}