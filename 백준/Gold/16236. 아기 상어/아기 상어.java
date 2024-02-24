import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static boolean[][] visit;
	public static int n;
	public static Queue<Integer> que = new LinkedList<>();
	public static int[] dr = {-1,0,0,1};
	public static int[] dc = {0,-1,1,0};
	public static int[] tmpArr = new int[2];
	public static boolean sharkEat;
	
	public static int sharkSize = 2;
	public static int eat = 0;
	public static int distance = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < n ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] == 9) {
					arr[r][c] = 0;
					visit[r][c] = true;
					que.add(r); que.add(c);
				}
			}
		}
		
		while(!que.isEmpty()) {
			bfs();
		}
		
		System.out.println(distance);
		
	}
	
	public static void bfs() {
		
		int tmpDistance = 0;
		
		while(!que.isEmpty()) {
			tmpDistance++;
			int size = que.size() /2;
			
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < n && c+dc[d] >= 0 && c+dc[d] < n && !visit[r+dr[d]][c+dc[d]]) {
						if(arr[r+dr[d]][c+dc[d]] > 0 && arr[r+dr[d]][c+dc[d]] < sharkSize) {
							if(!sharkEat) {
								tmpArr[0] = r+dr[d]; tmpArr[1] = c+dc[d];
								sharkEat = true;
							}
							else {
								if(r+dr[d] < tmpArr[0]) {
									tmpArr[0] = r+dr[d]; tmpArr[1] = c+dc[d];
								}
								else if(r+dr[d] == tmpArr[0] && c+dc[d] < tmpArr[1]) {
									tmpArr[0] = r+dr[d]; tmpArr[1] = c+dc[d];
								}
							}
						}
						else if(arr[r+dr[d]][c+dc[d]] <= sharkSize){
							que.add(r+dr[d]); que.add(c+dc[d]);
							visit[r+dr[d]][c+dc[d]] = true;
						}
					}
				}
			}
			
			if(sharkEat) {
				sharkEat = false;
				arr[tmpArr[0]][tmpArr[1]] = 0;
				eat++;
				if(eat == sharkSize) {
					sharkSize++;
					eat = 0;
				}
				que.clear();
				que.add(tmpArr[0]); que.add(tmpArr[1]);
				visit = new boolean[n][n];
				visit[tmpArr[0]][tmpArr[1]] = true;
				
				distance += tmpDistance;
				return;
			}
		}
	}
}
