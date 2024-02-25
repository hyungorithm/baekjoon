import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int R, C, T;
	public static int[][] arr;
	public static int mess = 0;
	public static int machineRow;
	public static Queue<Integer> que = new LinkedList<>();
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		
		for(int r = 0 ; r < R ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < C ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] > 0) {
					que.add(r); que.add(c);
					mess += arr[r][c];
				}
				else if(arr[r][c] == -1) {
					machineRow = r;
				}
			}
		}
		
//		for(int r = 0 ; r < R ; r++) {
//			for(int c = 0 ; c < C ; c++) {
//				System.out.print(arr[r][c]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		for(int i = 0 ; i < T ; i++) {
			spread();
			clean();
			que.clear();
			
			for(int r = 0 ; r < R ; r++) {
				for(int c = 0 ; c < C ; c++) {
					if(arr[r][c] > 0) {
						que.add(r); que.add(c);
					}
				}
			}
			
			if(mess == 0)
				break;
		}
		
		System.out.println(mess);
	}
	
	public static void spread() {
		int[][] addArr = new int[R][C];
		
		int size = que.size() / 2;
		
		for(int i = 0 ; i < size ; i++) {
			int r = que.poll();
			int c = que.poll();
			int mount = arr[r][c];
			for(int d = 0 ; d < 4 ; d++) {
				if(r+dr[d] >= 0 && r+dr[d] < R && c+dc[d] >= 0 && c+dc[d] < C && arr[r+dr[d]][c+dc[d]] >= 0) {
					addArr[r+dr[d]][c+dc[d]] += mount/5;
					addArr[r][c] -= mount/5;
//					que.add(r+dr[d]); que.add(c+dc[d]);
				}
			}
		}
		
		for(int r = 0 ; r < R ; r++) {
			for(int c = 0 ; c < C ; c++) {
				arr[r][c] += addArr[r][c];
			}
		}
	}
	
	public static void clean() {
		mess -= arr[machineRow - 2][0];
		mess -= arr[machineRow + 1][0];
		
		for(int r = machineRow - 2 ; r >= 1 ; r--) {
			arr[r][0] = arr[r-1][0];
		}
		for(int c = 0 ; c < C-1 ; c++) {
			arr[0][c] = arr[0][c+1];
		}
		for(int r = 0 ; r <= machineRow - 2 ; r++) {
			arr[r][C-1] = arr[r+1][C-1];
		}
		for(int c = C-1 ; c > 1 ; c--) {
			arr[machineRow-1][c] = arr[machineRow-1][c-1];
		}
		arr[machineRow-1][1] = 0;
		
		for(int r = machineRow + 1 ; r < R-1 ; r++) {
			arr[r][0] = arr[r+1][0];
		}
		for(int c = 0 ; c < C-1 ; c++) {
			arr[R-1][c] = arr[R-1][c+1];
		}
		for(int r = R-1 ; r > machineRow ; r--) {
			arr[r][C-1] = arr[r-1][C-1];
		}
		for(int c = C-1 ; c > 1 ; c--) {
			arr[machineRow][c] = arr[machineRow][c-1];
		}
		arr[machineRow][1] = 0;
		
	}
}
