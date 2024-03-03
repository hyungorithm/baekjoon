import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, cnt;
	static int[] arr;
	static int[][] arr1, arr2;
	
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int x = (int) (Math.sqrt(N));
		int y = x;
		
		if(N-(x*x) >= x) {
			y++;
		}
		int z = N-(x*y);
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			cnt++;
			arr1 = new int[y][x+z];
			arr2 = new int[4][N/4];
			
			int min = 10001;
			for(int i = 0 ; i < N ; i++) {
				if(arr[i] < min) {
					min = arr[i];
				}
			}
			for(int i = 0 ; i < N ; i++) {
				if(arr[i] == min) {
					arr[i]++;
				}
			}
			
			int R = y-1; int C = x+z-1; int D = 0;
			for(int i = N-1 ; i >= 0 ; i--) {
				arr1[R][C] = arr[i];
				if(R+dr[D] < 0 || R+dr[D] >= y || C+dc[D] < 0 || (R != y-1 && C+dc[D] >= x) || arr1[R+dr[D]][C+dc[D]] > 0) {
					D = (D+1)%4;
				}
				
				R += dr[D];
				C += dc[D];
			}
			
			arrange1(y, x+z);
			
			int I = 0;
			for(int c = 0 ; c < x+z ; c++) {
				for(int r = y-1 ; r >= 0 ; r--) {
					if(arr1[r][c] > 0) {
						arr[I++] = arr1[r][c];
					}
				}
			}
			
			for(int i = 0 ; i < N/4 ; i++) {
				arr2[2][N/4-1-i] = arr[i];
				arr2[1][i] = arr[N/4+i];
				arr2[0][N/4-1-i] = arr[N/2+i];
				arr2[3][i] = arr[3*N/4+i];
			}
			
			arrange2(4, N/4);
			
			I = 0;
			for(int c = 0 ; c < N/4 ; c++) {
				for(int r = 3 ; r >= 0 ; r--) {
					if(arr2[r][c] > 0) {
						arr[I++] = arr2[r][c];
					}
				}
			}
			
			int tmpmin = 10001; int tmpmax = 0;
			for(int i = 0 ; i < N ; i++) {
				if(arr[i] < tmpmin) {
					tmpmin = arr[i];
				}
				if(arr[i] > tmpmax) {
					tmpmax = arr[i];
				}
			}
			if(tmpmax - tmpmin <= K) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void arrange1(int R, int C) {
		int[][] tmp = new int[R][C];
		
		for(int r = 0 ; r < R ; r++) {
			for(int c = 0 ; c < C ; c++) {
				if(arr1[r][c] == 0) continue;
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < R && c+dc[d] >= 0 && c+dc[d] < C && arr1[r+dr[d]][c+dc[d]] > 0 && (arr1[r][c]-arr1[r+dr[d]][c+dc[d]]) >= 5) {
						int dd = (arr1[r][c]-arr1[r+dr[d]][c+dc[d]]) / 5;
						tmp[r][c] -= dd;
						tmp[r+dr[d]][c+dc[d]] += dd;
					}
				}
			}
		}
		
		for(int r = 0 ; r < R ; r++) {
			for(int c = 0 ; c < C ; c++) {
				arr1[r][c] += tmp[r][c];
			}
		}
	}
	
	static void arrange2(int R, int C) {
		int[][] tmp = new int[R][C];
		
		for(int r = 0 ; r < R ; r++) {
			for(int c = 0 ; c < C ; c++) {
				if(arr2[r][c] == 0) continue;
				for(int d = 0 ; d < 4 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < R && c+dc[d] >= 0 && c+dc[d] < C && arr2[r+dr[d]][c+dc[d]] > 0 && (arr2[r][c]-arr2[r+dr[d]][c+dc[d]]) >= 5) {
						int dd = (arr2[r][c]-arr2[r+dr[d]][c+dc[d]]) / 5;
						tmp[r][c] -= dd;
						tmp[r+dr[d]][c+dc[d]] += dd;
					}
				}
			}
		}
		
		for(int r = 0 ; r < R ; r++) {
			for(int c = 0 ; c < C ; c++) {
				arr2[r][c] += tmp[r][c];
			}
		}
	}
	
}