import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][][] arr;
	static boolean[][] same;
	static Queue<Integer> que = new LinkedList<>();
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N][4];
		same = new boolean[N][N];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[r][c][0] = m;
			arr[r][c][1] = s;
			arr[r][c][2] = d;
			arr[r][c][3] = 1;
			
			que.add(r); que.add(c);
		}
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				System.out.print(Arrays.toString(arr[r][c])+" ");
			}
			System.out.println();
		}
		
		for(int i = 0 ; i < K ; i++) {
			
		}
		
	}
	
	static void ballMove() {
		int size = que.size() /2;
		for(int i = 0 ; i < size ; i++) {
			int r = que.poll();
			int c = que.poll();
			
			if(arr[r][c][3] == 1) {
				if(arr[(r + dr[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][(c + dc[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][3] == 0) {
					arr[(r + dr[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][(c + dc[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][0] = arr[r][c][0];
					arr[(r + dr[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][(c + dc[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][1] = arr[r][c][1];
					arr[(r + dr[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][(c + dc[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][2] = arr[r][c][2];
					arr[(r + dr[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][(c + dc[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N][3] = arr[r][c][3];
					que.add((r + dr[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N); que.add((c + dc[arr[r][c][2]]*arr[r][c][1] + 1000*N) %N);
					Arrays.fill(arr[r][c], 0);
				}
				
			}
			
			
		}
		
	}
}
