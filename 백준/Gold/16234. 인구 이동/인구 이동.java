import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int[][] arr;
	static Queue<Integer> que = new LinkedList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int id = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}			
		}
		
		int cnt = 0;
		while(true) {
			move();
			if(id == N*N+1)
				break;
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void move() {
		int[][] tmp = new int[N][N];
		id = 1;
		int[][] sum = new int[N*N+1][2];
		
		for(int rr = 0 ; rr < N ; rr++) {
			for(int cc = 0 ; cc < N ; cc++) {
				if(tmp[rr][cc] == 0) {
					que.add(rr);
					que.add(cc);
					tmp[rr][cc] = id;
					sum[id][0] += arr[rr][cc];
					sum[id][1]++;
					while(!que.isEmpty()) {
						int r = que.poll();
						int c = que.poll();
						for(int d = 0 ; d < 4 ; d++) {
							if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && tmp[r+dr[d]][c+dc[d]] == 0) {
								int diff = Math.abs(arr[r][c] - arr[r+dr[d]][c+dc[d]]);
								if(diff <= R && diff >= L) {
									que.add(r+dr[d]);
									que.add(c+dc[d]);
									tmp[r+dr[d]][c+dc[d]] = id;
									sum[id][0] += arr[r+dr[d]][c+dc[d]];
									sum[id][1]++;
								}
							}
						}
					}
					id++;
				}
			}
		}
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				arr[r][c] = sum[tmp[r][c]][0] / sum[tmp[r][c]][1];
			}
		}
	}
}
