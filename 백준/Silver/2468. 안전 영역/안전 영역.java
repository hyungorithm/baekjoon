import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static Queue<Integer> que = new LinkedList<>();
	static boolean[][] tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		int min = 101; int max = 0;
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());				
			for(int c = 0 ; c < N ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] > max) {
					max = arr[r][c];
				}
				if(arr[r][c] < min) {
					min = arr[r][c];
				}
			}
		}
		
		int MAX = 1;
		
		for(int i = min ; i < max ; i++) {
			int cnt = 0;
			tmp = new boolean[N][N];
			for(int r = 0 ; r < N ; r++) {				
				for(int c = 0 ; c < N ; c++) {
					if(arr[r][c] > i && !tmp[r][c]) {
						tmp[r][c] = true;
						que.add(r); que.add(c);
						bfs(i);
						cnt++;
					}
				}
			}
			if(cnt > MAX) {
				MAX = cnt;
			}
		}
		System.out.println(MAX);
	}
	
	public static void bfs(int I) {
		while(!que.isEmpty()) {
			int size = que.size() / 2;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && arr[r+dr[d]][c+dc[d]] > I && !tmp[r+dr[d]][c+dc[d]]) {
						que.add(r+dr[d]); que.add(c+dc[d]);
						tmp[r+dr[d]][c+dc[d]] = true;
					}
				}
			}
		}
	}
}