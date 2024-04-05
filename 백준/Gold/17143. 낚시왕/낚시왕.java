import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static Queue<Integer> que = new LinkedList<>();
	static int[][][] map;
	static int R, C, M;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C][3];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken()) -1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) -1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c][0] = s;
			map[r][c][1] = d;
			map[r][c][2] = z;
			que.add(r); que.add(c);
		}
		
//		for(int r = 0 ; r < R ; r++) {
//			for(int c = 0 ; c < C ; c++) {
//				System.out.print(map[r][c][0]+""+map[r][c][1]+""+map[r][c][2]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int ans = 0;
		for(int c = 0 ; c < C ; c++) {
			for(int r = 0 ; r < R ; r++) {
				if(map[r][c][2]==0) continue;
				ans += map[r][c][2];
				map[r][c][0] = 0;
				map[r][c][1] = 0;
				map[r][c][2] = 0;
				break;
			}
			sharkMove();
//			System.out.println(ans);
		}
		System.out.println(ans);
	}
	
	private static void sharkMove() {
		int[][][] tmpMap = new int[R][C][3];
		
		int size = que.size()/2;
		for(int i = 0 ; i < size ; i++) {
			int r = que.poll();
			int c = que.poll();
			if(map[r][c][2]==0) continue;
			
			int nr = r;
			int nc = c;
			int tmpD;
			if(map[r][c][1] < 2) {
				if(map[r][c][1] == 1) {
					int tmp = (r+map[r][c][0]) % ((R-1)*2);
					if(tmp < (R-1)*2 - tmp) {
						nr = tmp;
						tmpD = 1;
					}
					else {
						nr = (R-1)*2 - tmp;
						tmpD = 0;
					}				
				}
				else {
					int tmp = (1000*(R-1)+r-map[r][c][0]) % ((R-1)*2);
					if(tmp <= (R-1)*2 - tmp) {
						nr = tmp;
						tmpD = 0;
					}
					else {
						nr = (R-1)*2 - tmp;
						tmpD = 1;
					}
				}
			}
			else {
				if(map[r][c][1] == 2) {
					int tmp = (c+map[r][c][0]) % ((C-1)*2);
					if(tmp < (C-1)*2 - tmp) {
						nc = tmp;
						tmpD = 2;
					}
					else {
						nc = (C-1)*2 - tmp;
						tmpD = 3;
					}
				}
				else {
					int tmp = (1000*(C-1)+c-map[r][c][0]) % ((C-1)*2);
					if(tmp <= (C-1)*2 - tmp) {
						nc = tmp;
						tmpD = 3;
					}
					else {
						nc = (C-1)*2 - tmp;
						tmpD = 2;
					}				
				}
			}
			if(tmpMap[nr][nc][2] > 0) {
				if(tmpMap[nr][nc][2] > map[r][c][2]) {
					map[r][c][0] = 0;
					map[r][c][1] = 0;
					map[r][c][2] = 0;
					continue;
				}
			}
			else {
				que.add(nr); que.add(nc);
			}
			tmpMap[nr][nc][0] = map[r][c][0];
			tmpMap[nr][nc][1] = tmpD;
			tmpMap[nr][nc][2] = map[r][c][2];
			map[r][c][0] = 0;
			map[r][c][1] = 0;
			map[r][c][2] = 0;
		}
		
		size = que.size()/2;
		for(int i = 0 ; i < size ; i++) {
			int r = que.poll();
			int c = que.poll();
			
			map[r][c][0] = tmpMap[r][c][0];
			map[r][c][1] = tmpMap[r][c][1];
			map[r][c][2] = tmpMap[r][c][2];
			
			que.add(r); que.add(c);
		}
		
//		for(int r = 0 ; r < R ; r++) {
//			for(int c = 0 ; c < C ; c++) {
//				System.out.print(map[r][c][0]+""+map[r][c][1]+""+map[r][c][2]+" ");
//			}
//			System.out.println();
//		}
	}
}