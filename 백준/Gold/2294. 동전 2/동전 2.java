import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] m = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		
		for(int i = 1 ; i <= n ; i++) {
			m[i] = Integer.parseInt(br.readLine());
		}
		
		for(int c = 0 ; c <= k ; c++) {
			dp[0][c] = 987654321;
		}
		
		for(int r = 1 ; r <= n ; r++) {
			for(int c = 1 ; c <= k ; c++) {
				if(c-m[r] >= 0) {
					dp[r][c] = Math.min(dp[r-1][c], dp[r][c-m[r]]+1);					
				}
				else dp[r][c] = dp[r-1][c];
			}
		}
		
		if(dp[n][k] == 987654321) System.out.println(-1);
		else System.out.println(dp[n][k]);
	}
}
