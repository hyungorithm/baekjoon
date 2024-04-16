import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static Queue<Integer> que = new LinkedList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int W = 1;
	static int cnt;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int r = 0 ; r < N ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < M ; c++) {
				arr[r][c] = str.charAt(c)-'0';
			}
		}
		
		for(W = 1 ; W <= 9 ; W++) {
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < M ; c++) {
					if(arr[r][c] == W) {
						visit = new boolean[N][M];
						que.add(r);
						que.add(c);
						visit[r][c] = true;
						BFS();
//						for(int rr = 0 ; rr < N ; rr++) {
//							for(int cc = 0 ; cc < M ; cc++) {
//								System.out.print(arr[rr][cc]+" ");
//							}
//							System.out.println();
//						}
//						System.out.println();
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
	private static void BFS() {
		boolean no = false;
		
		while(!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			for(int d = 0 ; d < 4 ; d++) {
				if(r+dr[d] < 0 || r+dr[d] >= N || c+dc[d] < 0 || c+dc[d] >= M || arr[r+dr[d]][c+dc[d]] == 0) {
					no = true;
					continue;
				}
				else if(arr[r+dr[d]][c+dc[d]] == W && !visit[r+dr[d]][c+dc[d]]) {
					que.add(r+dr[d]);
					que.add(c+dc[d]);
					visit[r+dr[d]][c+dc[d]] = true;
				}
			}
		}
		
		if(no) {
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < M ; c++) {
					if(visit[r][c]) arr[r][c] = 0;
				}
			}
		}
		else {
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < M ; c++) {
					if(visit[r][c]) {
						arr[r][c]++;
						cnt++;						
					}
				}
			}
		}
		
	}
}
