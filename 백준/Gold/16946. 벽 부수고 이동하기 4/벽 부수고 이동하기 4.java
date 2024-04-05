import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int cnt;
	
	static int id = 2;
	static Queue<Integer> bbq = new LinkedList<>();
	static int[] tmp = new int[4];
	static int[] zeros = new int[500002];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int r = 0 ; r < N ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < M ; c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < M ; c++) {
				if(arr[r][c] == 0) {
					cnt = 0;
					arr[r][c] = id;
					bbq.add(r); bbq.add(c);
					BFS();
					zeros[id] = cnt;
					id++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < M ; c++) {
				if(arr[r][c] == 1) {
					tmp[0] = 0; tmp[1] = 0; tmp[2] = 0; tmp[3] = 0; 
					loop:
					for(int d = 0 ; d < 4 ; d++) {
						if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < M && arr[r+dr[d]][c+dc[d]] > 1) {
							for(int dd = 0 ; dd < d ; dd++) {
								if(arr[r+dr[d]][c+dc[d]] == tmp[dd]) continue loop;
							}
							tmp[d] = arr[r+dr[d]][c+dc[d]];
						}
					}
					sb.append((zeros[tmp[0]]+zeros[tmp[1]]+zeros[tmp[2]]+zeros[tmp[3]]+1)%10);
				}
				else sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void BFS() {
		while(!bbq.isEmpty()) {
			int r = bbq.poll();
			int c = bbq.poll();
			cnt = (cnt+1)%10;
			
			for(int d = 0 ; d < 4 ; d++) {
				if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < M && arr[r+dr[d]][c+dc[d]] == 0) {
					arr[r+dr[d]][c+dc[d]] = id;
					bbq.add(r+dr[d]); bbq.add(c+dc[d]);
				}
			}
		}
	}
}
