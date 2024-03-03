import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int M, N, K; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int ti = 0 ; ti < t ; ti++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new boolean[M][N];
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[r][c] = true;
			}
			
			int cnt = 0;
			for(int r = 0 ; r < M ; r++) {
				for(int c = 0 ; c < N ; c++) {
					if(arr[r][c]) {
						arr[r][c] = false;
						dfs(r,c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void dfs(int r, int c) {
		for(int d = 0 ; d < 4 ; d++) {
			if(r+dr[d] >= 0 && r+dr[d] < M && c+dc[d] >= 0 && c+dc[d] < N && arr[r+dr[d]][c+dc[d]]) {
				arr[r+dr[d]][c+dc[d]] = false;
				dfs(r+dr[d], c+dc[d]);
			}
		}
	}
}