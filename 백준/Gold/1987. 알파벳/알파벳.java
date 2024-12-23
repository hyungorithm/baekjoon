import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int R, C;
	static int[][] graph;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int cnt = 0;
	static int max = 0;
	static boolean[] visit = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		
		for(int r = 0 ; r < R ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < C ; c++) {
				graph[r][c] = str.charAt(c) - 'A';
			}
		}
		
		visit[graph[0][0]] = true;
		
		DFS(0,0,1);
		
		System.out.println(max);
	}

	private static void DFS(int r, int c, int depth) {
		if(depth > max) max = depth;
		
		for(int d = 0 ; d < 4 ; d++) {
			if(r+dr[d] >= 0 && r+dr[d] < R && c+dc[d] >= 0 && c+dc[d] < C && !visit[graph[r+dr[d]][c+dc[d]]]) {
				visit[graph[r+dr[d]][c+dc[d]]] = true;
				DFS(r+dr[d], c+dc[d], depth+1);
				visit[graph[r+dr[d]][c+dc[d]]] = false;
			}
		}
	}
	
	
}