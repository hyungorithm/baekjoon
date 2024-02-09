import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[][] map;
	public static Queue<Integer> que = new LinkedList<>();
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,-1,0,1};
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < n ; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c < n ; c++) {
				if(map[r][c] == 1) {
					map[r][c] = 0;
					que.add(r); que.add(c);
					bfs();
				}
			}
		}
		
		arr.sort(null);
		System.out.println(arr.size());
		for(int i = 0 ; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	}
	
	public static void bfs() {
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int size = que.size() / 2;
			
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				cnt++;
				
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < n && c+dc[d] >= 0 && c+dc[d] < n) {
						if(map[r+dr[d]][c+dc[d]] == 1) {
							que.add(r+dr[d]); que.add(c+dc[d]); 
							map[r+dr[d]][c+dc[d]] = 0;
						}
					}
				}
			}
		}
		
		arr.add(cnt);

	}
	
}
