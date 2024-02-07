import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][][] map;
	public static Queue<Integer> que = new LinkedList<>();
	public static int n;
	public static int m;
	public static int h;
	public static int cnt = -1;
	
	public static int[] dr = {-1,0,1,0,0,0};
	public static int[] dc = {0,-1,0,1,0,0};
	public static int[] dz = {0,0,0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][m][n];
		
		for(int z = 0 ; z < h ; z++) {
			for(int r = 0 ; r < m ; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0 ; c < n ; c++) {
					map[z][r][c] = Integer.parseInt(st.nextToken());
					if(map[z][r][c] == 1) {
						que.add(r); que.add(c); que.add(z);
					}
				}
			}
		}
		bfs();
		System.out.println(cnt);
	}
	
	public static void bfs() {
		
		while (!que.isEmpty()) {
			int size = que.size()/3;
			for(int i = 0 ; i < size ; i++) {
				
				int r = que.poll();
				int c = que.poll();
				int z = que.poll();
				
				for(int d = 0 ; d <= 5 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < m && c+dc[d] >= 0 && c+dc[d] < n && z+dz[d] >= 0 && z+dz[d] < h && map[z+dz[d]][r+dr[d]][c+dc[d]] == 0) {
						map[z+dz[d]][r+dr[d]][c+dc[d]] = 1;
						que.add(r+dr[d]); que.add(c+dc[d]); que.add(z+dz[d]);
					}
				}
			}
			cnt++;
		}
		
		test:
		for(int z = 0 ; z < h ; z++) {
			for(int r = 0 ; r < m ; r++) {
				for(int c = 0 ; c < n ; c++) {
					if(map[z][r][c] == 0) {
						cnt = -1;
						break test;
					}
				}
			}
		}
		
	}
}