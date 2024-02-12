import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		int[][] sum = new int[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < n ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c < n ; c++) {
				if(r != 0) {
					sum[r][c] = sum[r-1][c];
				}
				for(int ci = 0 ; ci <= c ; ci++) {
					sum[r][c] += arr[r][ci];
				}
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			if(x1 == 0 && y1 == 0) {
				System.out.println(sum[x2][y2]);
			}
			else if(y1 == 0) {
				System.out.println(sum[x2][y2] - sum[x1-1][y2]);
			}
			else if(x1 == 0) {
				System.out.println(sum[x2][y2] - sum[x2][y1-1]);
			}
			else {
				System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
			}
		}
		
		
	}
}