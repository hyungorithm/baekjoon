import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][k+1];
		
		for(int r = 1 ; r <= n ; r++) {
			dp[r][0] = 1;
			for(int c = 1 ; c <= k ; c++) {
				dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % 1000000000;
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
