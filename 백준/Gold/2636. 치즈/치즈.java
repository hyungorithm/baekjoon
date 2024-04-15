import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] tmp;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int mount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tmp = new boolean[N][M];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < M ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] == 1) mount++;
			}			
		}
		
		DFS(0,0);
		
		int cnt = 0;
		boolean ok = false;
		
		while(true) {
			cnt++;
			tmp = new boolean[N][M];
			int mnt = 0;
			
			for(int r = 1 ; r < N-1 ; r++) {
				for(int c = 1 ; c < M-1 ; c++) {
					if(arr[r][c] == 1) {
						for(int d = 0 ; d < 4 ; d++) {
							if(arr[r+dr[d]][c+dc[d]] == 2) {
								mnt++;
								tmp[r][c] = true;
								break;
							}
						}
					}
				}
			}
			
			for(int r = 1 ; r < N-1 ; r++) {
				for(int c = 1 ; c < M-1 ; c++) {
					if(tmp[r][c]) {
						arr[r][c] = 2;
						for(int d = 0 ; d < 4 ; d++) {
							if(arr[r+dr[d]][c+dc[d]] == 0) {
								DFS(r+dr[d], c+dc[d]);
							}
						}
					}
				}
			}
			
			if(mount==mnt) {
				System.out.println(cnt);
				System.out.println(mnt);
				return;
			}
			mount -= mnt;
		}
	}
	private static void DFS(int r, int c) {
		arr[r][c] = 2;
		for(int d = 0 ; d < 4 ; d++) {
			if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < M && arr[r+dr[d]][c+dc[d]] == 0) {
				DFS(r+dr[d], c+dc[d]);
			}
		}
	}
}
