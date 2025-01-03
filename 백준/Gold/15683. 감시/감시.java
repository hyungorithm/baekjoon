import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[][] graph;
	static int[] cctv = new int[24];
	static int cctv_cnt = 0;
	static int sagak = 0;
	static int min = 9999999;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];

		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < M ; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
				if(graph[r][c] == 0) {
					sagak++;
				}
				else if(graph[r][c] <= 5) {
					cctv[cctv_cnt*3] = graph[r][c];
					cctv[cctv_cnt*3 + 1] = r;
					cctv[cctv_cnt*3 + 2] = c;
					cctv_cnt++;
				}
			}
		}
		
		CCTV_SELECT(0);
		System.out.println(min);
	}
	
	static void CCTV_SELECT(int depth) {
		if(depth == cctv_cnt) {
//			for(int r = 0 ; r < N ; r++) {
//				for(int c = 0 ; c < M ; c++) {
//					System.out.print(graph[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			if(sagak < min) min = sagak;
			return;
		}
		
		int r = cctv[depth*3 + 1];
		int c = cctv[depth*3 + 2];
		
		if(cctv[depth*3] == 1) {
			for(int d = 0 ; d < 4 ; d++) {
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				CCTV_SELECT(depth+1);
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
			}
		}
		
		else if(cctv[depth*3] == 2) {
			for(int d = 0 ; d < 2 ; d++) {
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				d += 2;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				CCTV_SELECT(depth+1);
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
				d -= 2;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
			}
		}
		
		else if(cctv[depth*3] == 3) {
			for(int d = 0 ; d < 4 ; d++) {
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				d = (d+1)%4;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				CCTV_SELECT(depth+1);
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
				d = (d+3)%4;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
			}
		}
		
		else if(cctv[depth*3] == 4) {
			for(int d = 0 ; d < 4 ; d++) {
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				d = (d+1)%4;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				d = (d+1)%4;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
				CCTV_SELECT(depth+1);
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
				d = (d+3)%4;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
				d = (d+3)%4;
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
			}
		}
		
		else if(cctv[depth*3] == 5) {
			for(int d = 0 ; d < 4 ; d++) {
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak--;
					graph[r+dr[d]*l][c+dc[d]*l] += 10;
				}
			}
			CCTV_SELECT(depth+1);
			for(int d = 0 ; d < 4 ; d++) {
				for(int l = 1 ; l < 8 ; l++) {
					if(r+dr[d]*l < 0 || r+dr[d]*l >= N || c+dc[d]*l < 0 || c+dc[d]*l >= M || graph[r+dr[d]*l][c+dc[d]*l] == 6) {
						break;
					}
					graph[r+dr[d]*l][c+dc[d]*l] -= 10;
					if(graph[r+dr[d]*l][c+dc[d]*l] == 0) sagak++;
				}
			}
		}
	}
}