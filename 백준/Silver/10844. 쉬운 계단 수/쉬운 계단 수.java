import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N+1][10];
		
		for(int i = 1 ; i <= 9 ; i++) {
			arr[1][i] = 1;
		}
		
		for(int n = 2 ; n <= N ; n++) {
			for(int i = 0 ; i <= 9 ; i++) {
				if(i==0) {
					arr[n][i] = arr[n-1][i+1]%1000000000;
				}
				else if(i==9) {
					arr[n][i] = arr[n-1][i-1]%1000000000;
				}
				else {
					arr[n][i] = arr[n-1][i+1]%1000000000 + arr[n-1][i-1]%1000000000;
				}
			}
		}
		
		long ans = 0;
		for(int i = 0 ; i <= 9 ; i++) {
			ans += arr[N][i];
		}
		System.out.println(ans%1000000000);
	}
}
