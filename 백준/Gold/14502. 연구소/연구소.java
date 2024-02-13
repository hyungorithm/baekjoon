import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1,1,0,0};
	public static int[] dc = {0,0,-1,1};
	public static int[][] map;
	public static boolean[][] visitMap;
	public static int[] zeros = new int[128];
	public static int[] virus = new int[20];
	public static int[] wall = new int[6];
	public static int n;
	public static int m;
	public static int zeroSum;
	public static int max = 0;
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visitMap = new boolean[n][m];
		Arrays.fill(zeros, -1);
		Arrays.fill(virus, -1);
		
		int zeroCount = -1;
		int virusCount = -1;
		for(int r = 0 ; r < n ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < m ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 0) {
					zeros[++zeroCount] = r;
					zeros[++zeroCount] = c;
					zeroSum++;
				}
				else if(map[r][c] == 2) {
					virus[++virusCount] = r;
					virus[++virusCount] = c;
				}
			}
		}
		
		comb(0);
		System.out.println(max-3);
	}
	
	public static void comb(int depth) {
		if(depth == 3) {
			
			int sum = zeroSum;
			for(int i = 0 ; i < 20 ; i += 2) {
				if(virus[i] == -1)
					break;
				else {
					sum -= dfs(virus[i], virus[i+1]);
					count = 0;
				}
			}
			if (sum > max) {
				max = sum;
			}
			for(int i = 0 ; i < n ; i++) {
				Arrays.fill(visitMap[i], false);
			}
			return;
		}
		
		for(int i = 0 ; i < 128 ; i += 2) {
			if(zeros[i] == -1)
				break;
			else if(map[zeros[i]][zeros[i+1]] == 0) {
				map[zeros[i]][zeros[i+1]] = 1;
				
				comb(depth + 1);
				
				map[zeros[i]][zeros[i+1]] = 0;
			}
		}
	}
	
	public static int dfs(int r, int c) {
		visitMap[r][c] = true;
		
		for(int d = 0 ; d < 4 ; d++) {
			if(r+dr[d] >= 0 && r+dr[d] < n && c+dc[d] >= 0 && c+dc[d] < m) {
				if(!visitMap[r+dr[d]][c+dc[d]] && map[r+dr[d]][c+dc[d]] == 0) {
					count++;
					
					visitMap[r+dr[d]][c+dc[d]] = true;
					dfs(r+dr[d], c+dc[d]);
				}
			}
		}
		return count;
	}
}
