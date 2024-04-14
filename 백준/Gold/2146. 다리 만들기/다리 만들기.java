import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] tmp;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int id = 2;
	static int I, cnt;
	static int min = 987654321;
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		tmp = new boolean[N][N];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}			
		}
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				if(arr[r][c] == 1) {
					DFS(r, c);
					id++;
				}
			}
		}
		
		for(I = 2 ; I < id ; I++) {
			tmp = new boolean[N][N];
			que.clear();
			
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					if(arr[r][c] == I) {
						tmp[r][c] = true;
						que.add(r);
						que.add(c);
					}
				}
			}
			
			cnt = 0;
			BFS();
			if(cnt < min) min = cnt;
		}
		System.out.println(min);
	}
	
	private static void DFS(int r, int c) {
		arr[r][c] = id;
		for(int d = 0 ; d < 4 ; d++) {
			if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && arr[r+dr[d]][c+dc[d]] == 1) {
				DFS(r+dr[d], c+dc[d]);
			}
		}
	}
	
	private static void BFS() {
		loop:
		while(!que.isEmpty()) {
			int size = que.size()/2;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && !tmp[r+dr[d]][c+dc[d]]) {
						if(arr[r+dr[d]][c+dc[d]] != 0 && arr[r+dr[d]][c+dc[d]] != I) break loop;
						tmp[r+dr[d]][c+dc[d]] = true;
						que.add(r+dr[d]);
						que.add(c+dc[d]);
					}
				}
			}
			cnt++;
		}
	}
}
