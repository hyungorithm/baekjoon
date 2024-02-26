import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] d = new int[3][n];
		int[][] arr = new int[3][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			arr[2][i] = Integer.parseInt(st.nextToken());
		}
		
		d[0][0] = arr[0][0];
		d[1][0] = arr[1][0];
		d[2][0] = arr[2][0];
		
		for(int i = 1 ; i < n ; i++) {
			d[0][i] = Math.min(d[1][i-1], d[2][i-1]) + arr[0][i];
			d[1][i] = Math.min(d[0][i-1], d[2][i-1]) + arr[1][i];
			d[2][i] = Math.min(d[0][i-1], d[1][i-1]) + arr[2][i];
		}
		
		System.out.println(Math.min(Math.min(d[0][n-1], d[1][n-1]), d[2][n-1]));
		
	}
}
