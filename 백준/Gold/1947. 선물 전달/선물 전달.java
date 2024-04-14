import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) { System.out.println(0); return; }
		if(n == 2) { System.out.println(1); return; }
		if(n == 3) { System.out.println(2); return; }
		
		long[] dp = new long[n+1];
		dp[2] = 1;
		dp[3] = 2;
		
		for(int i = 4 ; i <= n ; i++) {
			dp[i] = (dp[i-2] + dp[i-1])*(i-1) % 1000000000;
		}
		System.out.println(dp[n]);
	}
}
