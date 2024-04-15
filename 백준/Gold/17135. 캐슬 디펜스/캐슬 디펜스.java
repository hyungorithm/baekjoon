import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,D;
	static int[][] origin;
	static int[][] arr;
	static boolean[] select;
	static Queue<Integer> que = new LinkedList<>();
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	static int cnt, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		arr = new int[N][M];
		select = new boolean[M];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < M ; c++) {
				origin[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(max);
	}

	private static void comb(int depth, int idx) {
		if(depth == 3) {
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < M ; c++) {
					arr[r][c] = origin[r][c];
				}
			}
			
			simul();
			if(cnt > max) max = cnt;
			return;
		}
		
		for(int i = idx ; i < M ; i++) {
			if(!select[i]) {
				select[i] = true;
				cnt = 0;
				comb(depth+1, i+1);
				select[i] = false;
			}
		}
	}

	private static void simul() {
		boolean[][] tmp = new boolean[N][M];
		que.clear();
		
//		System.out.println(cnt);
//		for(int r = 0 ; r < N ; r++) {
//			for(int c = 0 ; c < M ; c++) {
//				System.out.print(arr[r][c]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		for(int t = 0 ; t < N ; t++) {
			tmp = new boolean[N][M];
			attack:
				for(int i = 0 ; i < M ; i++) {
					if(select[i]) {
						que.clear();
						que.add(N);
						que.add(i);
						for(int w = 0 ; w < D ; w++) {
							int size = que.size()/2;
							for(int qi = 0 ; qi < size ; qi++) {
								int r = que.poll();
								int c = que.poll();
								for(int d = 0 ; d < 4 ; d++) {
									if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < M) {
										if(arr[r+dr[d]][c+dc[d]] == 1) {
//											System.out.print(r+" "+c+"  "+(r+dr[d])+" "+(c+dc[d]));
											tmp[r+dr[d]][c+dc[d]] = true;
											continue attack;
										}
										que.add(r+dr[d]);
										que.add(c+dc[d]);
									}
								}
							}
						}
					}
				}
//			System.out.println(Arrays.toString(select));
//			System.out.println(cnt);
//			for(int r = 0 ; r < N ; r++) {
//				for(int c = 0 ; c < M ; c++) {
//					System.out.print(arr[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			for(int r = 0 ; r < N ; r++) {
//				for(int c = 0 ; c < M ; c++) {
//					System.out.print(tmp[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			for(int r = N-1 ; r >= 0 ; r--) {
				for(int c = 0 ; c < M ; c++) {
					if(tmp[r][c]) {
						arr[r][c] = 0;
						cnt++;
					}
					if(r == N-1) continue;
					arr[r+1][c] = arr[r][c];
				}
			}
			for(int c = 0 ; c < M ; c++) {
				arr[0][c] = 0;
			}
		}
		
	}
	
}
