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
		
		int[] sum = new int[n];
		long[] mod = new long[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			if(i == 0)
				sum[i] = Integer.parseInt(st.nextToken()) %m;
			else
				sum[i] = (sum[i-1] + Integer.parseInt(st.nextToken())) %m;
		}
		
		
		
		for(int i = 0 ; i < n ; i++) {
			mod[sum[i]]++;
		}
		
		long ans = mod[0];
		for(int i = 0 ; i < m ; i++) {
			ans += mod[i]*(mod[i]-1) /2;
		}
		
		System.out.println(ans);
	}
}