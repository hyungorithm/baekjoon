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
		
		int[] money = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		
		for(int i = 1 ; i <= n ; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		for(int ni = 1 ; ni <= n ; ni++) {
			dp[ni][0] = 1;
			for(int i = 1 ; i <= k ; i++) {
				if(i - money[ni] >= 0) {
					dp[ni][i] = dp[ni-1][i] + dp[ni][i-money[ni]];
				}
				else dp[ni][i] = dp[ni-1][i];
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
