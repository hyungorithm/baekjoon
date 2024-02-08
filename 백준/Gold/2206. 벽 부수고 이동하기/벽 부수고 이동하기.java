import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] map;
	public static Queue<Integer> que2 = new LinkedList<>();
	public static Queue<Integer> que3 = new LinkedList<>();
	public static int n;
	public static int m;
	public static int cnt = 1;
	
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int r = 0 ; r < n ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < m ; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		que2.add(0); que2.add(0);
		map[0][0] = 2;
		bfs();
		System.out.println(cnt);
	}
	
	public static void bfs() {
		if(m==1 && n==1) {
			cnt = 1;
			return;
		}
		
		
		while (!que2.isEmpty() || !que3.isEmpty()) {
			int size2 = que2.size()/2;
			int size3 = que3.size()/2;
			
			for(int i = 0 ; i < size2 ; i++) {
				int r = que2.poll();
				int c = que2.poll();
				
				for(int d = 0 ; d <= 3 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < n && c+dc[d] >= 0 && c+dc[d] < m && map[r][c] == 2) {
						if(map[r+dr[d]][c+dc[d]] == 0) {
							map[r+dr[d]][c+dc[d]] = 2;
							que2.add(r+dr[d]); que2.add(c+dc[d]);
						}
						else if(map[r+dr[d]][c+dc[d]] == 1) {
							map[r+dr[d]][c+dc[d]] = 4;
							que3.add(r+dr[d]); que3.add(c+dc[d]);
						}
						else if(map[r+dr[d]][c+dc[d]] == 3) {
							map[r+dr[d]][c+dc[d]] = 2;
							que2.add(r+dr[d]); que2.add(c+dc[d]);
						}
					}
				}
			}
			
			for(int i = 0 ; i < size3 ; i++) {
				int r = que3.poll();
				int c = que3.poll();
				
				for(int d = 0 ; d <= 3 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < n && c+dc[d] >= 0 && c+dc[d] < m && (map[r][c] == 3 || map[r][c] == 4)) {
						if(map[r+dr[d]][c+dc[d]] == 0) {
							map[r+dr[d]][c+dc[d]] = 3;
							que3.add(r+dr[d]); que3.add(c+dc[d]);
						}
					}
				}
				
			}
			cnt++;
			
			if(map[n-1][m-1] != 0)
				break;
		}
		
		if(map[n-1][m-1] == 0)
			cnt = -1;
		
	}
}