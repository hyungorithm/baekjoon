import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] arr;
	public static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr[0][0] = 2;
		arr[0][1] = 2;
		
		dfs(0,1);
		
		System.out.println(cnt);
	}
	
	
	public static void dfs(int r, int c) {
		if(arr[N-1][N-1] == 2) {
			cnt++;
			return;
		}
		
		if(arr[r][c-1] == 2) {
			arr[r][c-1] = 0;
			if(c+1 < N && arr[r][c+1] == 0) {
				arr[r][c+1] = 2;
				dfs(r,c+1);
				arr[r][c+1] = 0;
			}
			if(c+1 < N && r+1 < N && arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0) {
				arr[r+1][c+1] = 2;
				dfs(r+1,c+1);
				arr[r+1][c+1] = 0;
			}
			arr[r][c-1] = 2;
		}
		
		else if(r > 0 && arr[r-1][c-1] == 2) {
			arr[r-1][c-1] = 0;
			if(c+1 < N && arr[r][c+1] == 0) {
				arr[r][c+1] = 2;
				dfs(r,c+1);
				arr[r][c+1] = 0;
			}
			if(c+1 < N && r+1 < N && arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0) {
				arr[r+1][c+1] = 2;
				dfs(r+1,c+1);
				arr[r+1][c+1] = 0;
			}
			if(r+1 < N && arr[r+1][c] == 0) {
				arr[r+1][c] = 2;
				dfs(r+1,c);
				arr[r+1][c] = 0;
			}
			arr[r-1][c-1] = 2;
		}
		
		else if(r > 0 && arr[r-1][c] == 2) {
			arr[r-1][c] = 0;
			if(c+1 < N && r+1 < N && arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0) {
				arr[r+1][c+1] = 2;
				dfs(r+1,c+1);
				arr[r+1][c+1] = 0;
			}
			if(r+1 < N && arr[r+1][c] == 0) {
				arr[r+1][c] = 2;
				dfs(r+1,c);
				arr[r+1][c] = 0;
			}
			arr[r-1][c] = 2;
		}
	}
}
