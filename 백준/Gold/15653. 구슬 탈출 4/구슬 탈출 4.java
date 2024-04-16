import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Queue<Integer> que = new LinkedList<>();
	static int[][] arr;
	static boolean[] visit = new boolean[10000];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static char[] dd = {'U','L','D','R'};
	static int r1, r2, b1, b2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int r = 0 ; r < N ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < M ; c++) {
				arr[r][c] = str.charAt(c)-35;
				if(arr[r][c] == 47) {
					r1 = r; r2 = c;
				}
				else if(arr[r][c] == 31) {
					b1 = r; b2 = c;
				}
			}
		}
		
		que.add(r1);
		que.add(r2);
		que.add(b1);
		que.add(b2);
		visit[r1*1000+r2*100+b1*10+b2] = true;
		
		BFS();
		
	}

	private static void BFS() {
		int cnt = 0;
		boolean end = false;
		
		while(!que.isEmpty()) {
			cnt++;
			int size = que.size()/4;
			
			for(int i = 0 ; i < size ; i++) {
				int R1 = que.poll();
				int R2 = que.poll();
				int B1 = que.poll();
				int B2 = que.poll();
//				System.out.println(R1+" "+R2+" "+B1+" "+B2);
				
				loop:
				for(int d = 0 ; d < 4 ; d++) {
					int r1 = R1;
					int r2 = R2;
					int b1 = B1;
					int b2 = B2;
					
					if(d==0 && r2 == b2 && r1 > b1) {
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[b1+dr[d]*l][b2+dc[d]*l] == 0 || (b1+dr[d]*l == r1 && b2+dc[d]*l == r2)) {
								b1 = b1+dr[d]*(l-1);
								b2 = b2+dc[d]*(l-1);
								break;
							}
							else if(arr[b1+dr[d]*l][b2+dc[d]*l] == 44) {
								continue loop;
							}
						}
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[r1+dr[d]*l][r2+dc[d]*l] == 0 || (r1+dr[d]*l == b1 && r2+dc[d]*l == b2)) {
								r1 = r1+dr[d]*(l-1);
								r2 = r2+dc[d]*(l-1);
								break;
							}
							else if(arr[r1+dr[d]*l][r2+dc[d]*l] == 44) {
								System.out.println(cnt);
								return;
							}
						}
					}
					else if(d==1 && r1 == b1 && r2 > b2) {
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[b1+dr[d]*l][b2+dc[d]*l] == 0 || (b1+dr[d]*l == r1 && b2+dc[d]*l == r2)) {
								b1 = b1+dr[d]*(l-1);
								b2 = b2+dc[d]*(l-1);
								break;
							}
							else if(arr[b1+dr[d]*l][b2+dc[d]*l] == 44) {
								continue loop;
							}
						}
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[r1+dr[d]*l][r2+dc[d]*l] == 0 || (r1+dr[d]*l == b1 && r2+dc[d]*l == b2)) {
								r1 = r1+dr[d]*(l-1);
								r2 = r2+dc[d]*(l-1);
								break;
							}
							else if(arr[r1+dr[d]*l][r2+dc[d]*l] == 44) {
								System.out.println(cnt);
								return;
							}
						}
					}
					else if(d==2 && r2 == b2 && r1 < b1) {
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[b1+dr[d]*l][b2+dc[d]*l] == 0 || (b1+dr[d]*l == r1 && b2+dc[d]*l == r2)) {
								b1 = b1+dr[d]*(l-1);
								b2 = b2+dc[d]*(l-1);
								break;
							}
							else if(arr[b1+dr[d]*l][b2+dc[d]*l] == 44) {
								continue loop;
							}
						}
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[r1+dr[d]*l][r2+dc[d]*l] == 0 || (r1+dr[d]*l == b1 && r2+dc[d]*l == b2)) {
								r1 = r1+dr[d]*(l-1);
								r2 = r2+dc[d]*(l-1);
								break;
							}
							else if(arr[r1+dr[d]*l][r2+dc[d]*l] == 44) {
								System.out.println(cnt);
								return;
							}
						}
					}
					else if(d==3 && r1 == b1 && r2 < b2) {
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[b1+dr[d]*l][b2+dc[d]*l] == 0 || (b1+dr[d]*l == r1 && b2+dc[d]*l == r2)) {
								b1 = b1+dr[d]*(l-1);
								b2 = b2+dc[d]*(l-1);
								break;
							}
							else if(arr[b1+dr[d]*l][b2+dc[d]*l] == 44) {
								continue loop;
							}
						}
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[r1+dr[d]*l][r2+dc[d]*l] == 0 || (r1+dr[d]*l == b1 && r2+dc[d]*l == b2)) {
								r1 = r1+dr[d]*(l-1);
								r2 = r2+dc[d]*(l-1);
								break;
							}
							else if(arr[r1+dr[d]*l][r2+dc[d]*l] == 44) {
								System.out.println(cnt);
								return;
							}
						}
					}
					else {
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[r1+dr[d]*l][r2+dc[d]*l] == 0 || (r1+dr[d]*l == b1 && r2+dc[d]*l == b2)) {
								r1 = r1+dr[d]*(l-1);
								r2 = r2+dc[d]*(l-1);
								break;
							}
							else if(arr[r1+dr[d]*l][r2+dc[d]*l] == 44) {
								r1 = -1;
								r2 = -1;
								end = true;
								break;
							}
						}
						for(int l = 1 ; l < 10 ; l++) {
							if(arr[b1+dr[d]*l][b2+dc[d]*l] == 0 || (b1+dr[d]*l == r1 && b2+dc[d]*l == r2)) {
								b1 = b1+dr[d]*(l-1);
								b2 = b2+dc[d]*(l-1);
								break;
							}
							else if(arr[b1+dr[d]*l][b2+dc[d]*l] == 44) {
								end = false;
								continue loop;
							}
						}
					}
					
					if(end) {
						System.out.println(cnt);
						return;
					}
					
					if(!visit[r1*1000+r2*100+b1*10+b2]) {
						que.add(r1);
						que.add(r2);
						que.add(b1);
						que.add(b2);
						visit[r1*1000+r2*100+b1*10+b2] = true;
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}
