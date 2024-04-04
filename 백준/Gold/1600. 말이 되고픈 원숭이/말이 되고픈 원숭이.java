import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> que = new LinkedList<>();
	static int K,W,H;
	static int[][] arr;
	static boolean[][][] road;
	static int[] dr = {-1,0,1,0,-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {0,-1,0,1,1,2,2,1,-1,-2,-2,-1};
	static int[] dh = {0,0,0,0,1,1,1,1,1,1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		road = new boolean[H][W][K+1];
		
		for(int r = 0 ; r < H ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < W ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(W==1 && H==1) {
			System.out.println(0);
			return;
		}
		
		que.add(0); que.add(0); que.add(0);
		BFS();
		
	}
	
	static void BFS() {
		int cnt = 0;
		while(!que.isEmpty()) {
			cnt++;
			int size = que.size()/3;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				int h = que.poll();
				
				for(int d = 0 ; d < 12 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < H && c+dc[d] >= 0 && c+dc[d] < W && h+dh[d] >= 0 && h+dh[d] < K+1 && arr[r+dr[d]][c+dc[d]] == 0 && !road[r+dr[d]][c+dc[d]][h+dh[d]]) {
						if(r+dr[d] == H-1 && c+dc[d] == W-1) {
							System.out.println(cnt);
							return;
						}
						
						road[r+dr[d]][c+dc[d]][h+dh[d]] = true;
						que.add(r+dr[d]);
						que.add(c+dc[d]);
						que.add(h+dh[d]);
					}
				}
			}
		}
		System.out.println(-1);
	}
}
