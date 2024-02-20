import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] origin, arr1, arr2, arr3, arr4, arr5;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		origin = new int[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < n ; c++) {
				origin[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		fiveMove(origin, 0);
		
		System.out.println(max);
	}
	
	public static void fiveMove(int[][] arr, int moveNum) {
		if(moveNum == 5) {
			for(int r = 0 ; r < n ; r++) {
				for(int c = 0 ; c < n ; c++) {
					if(arr[r][c] > max) {
						max = arr[r][c];
					}
				}
			}
			return;
		}
		
		int[][] tmp;
		for(int d = 0 ; d < 4 ; d++) {
			if(d==0)
				tmp = Arrays.copyOf(moveLeft(arr), n);
			else if(d==1)
				tmp = Arrays.copyOf(moveRight(arr), n);
			else if(d==2)
				tmp = Arrays.copyOf(moveUp(arr), n);
			else
				tmp = Arrays.copyOf(moveDown(arr), n);
			
			fiveMove(Arrays.copyOf(tmp, n), moveNum+1);
		}
	}
	
	public static int[][] moveLeft(int[][] a) {
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Arrays.copyOf(a[i], n);
		}
		boolean[][] visit = new boolean[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			int newC = 0;
			for(int c = 0 ; c < n ; c++) {
				if(arr[r][c] != 0) {
					if(c != newC) {
						arr[r][newC] = arr[r][c];
						arr[r][c] = 0;
					}
					if(newC > 0 && arr[r][newC] == arr[r][newC-1] && !visit[r][newC-1]) {
						arr[r][newC-1] *= 2;
						arr[r][newC] = 0;
						visit[r][newC-1] = true;
						newC--;
					}
					newC++;
				}
			}
		}
		return arr;
	}
	
	public static int[][] moveRight(int[][] a) {
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Arrays.copyOf(a[i], n);
		}
		boolean[][] visit = new boolean[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			int newC = n-1;
			for(int c = n-1 ; c >= 0 ; c--) {
				if(arr[r][c] != 0) {
					if(c != newC) {
						arr[r][newC] = arr[r][c];
						arr[r][c] = 0;
					}
					if(newC < n-1 && arr[r][newC] == arr[r][newC+1] && !visit[r][newC+1]) {
						arr[r][newC+1] *= 2;
						arr[r][newC] = 0;
						visit[r][newC+1] = true;
						newC++;
					}
					newC--;
				}
			}
		}
		return arr;
	}
	
	public static int[][] moveUp(int[][] a) {
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Arrays.copyOf(a[i], n);
		}
		boolean[][] visit = new boolean[n][n];
		
		for(int c = 0 ; c < n ; c++) {
			int newR = 0;
			for(int r = 0 ; r < n ; r++) {
				if(arr[r][c] != 0) {
					if(r != newR) {
						arr[newR][c] = arr[r][c];
						arr[r][c] = 0;
					}
					if(newR > 0 && arr[newR][c] == arr[newR-1][c] && !visit[newR-1][c]) {
						arr[newR-1][c] *= 2;
						arr[newR][c] = 0;
						visit[newR-1][c] = true;
						newR--;
					}
					newR++;
				}
			}
		}
		return arr;
	}
	
	public static int[][] moveDown(int[][] a) {
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Arrays.copyOf(a[i], n);
		}
		boolean[][] visit = new boolean[n][n];
		
		for(int c = 0 ; c < n ; c++) {
			int newR = n-1;
			for(int r = n-1 ; r >= 0 ; r--) {
				if(arr[r][c] != 0) {
					if(r != newR) {
						arr[newR][c] = arr[r][c];
						arr[r][c] = 0;
					}
					if(newR < n-1 && arr[newR][c] == arr[newR+1][c] && !visit[newR+1][c]) {
						arr[newR+1][c] *= 2;
						arr[newR][c] = 0;
						visit[newR+1][c] = true;
						newR++;
					}
					newR--;
				}
			}
		}
		return arr;
	}
}
