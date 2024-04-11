import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[T];
        
        for(int ti = 0 ; ti < T ; ti++) {
        	int N = Integer.parseInt(br.readLine());
        	arr[ti] = N;
        	if(N > max) max = N;
        }
        
        int dp[] = new int[max+1];
        dp[1] = 1;
        for(int i = 2 ; i <= max ; i++) {
        	dp[i] = dp[i-1];
        	dp[i] += (i/6 + 1);
        	if(i%6==1) dp[i]--;
        }
        
        for(int i = 0 ; i < T ; i++) {
        	System.out.println(dp[arr[i]]);
        }
    }
}