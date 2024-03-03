import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] sum = new int[n+1];

		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n-1 ; i >= 0 ; i--) {
			if(arr[i][0] > n-i) {
				sum[i] = sum[i+1];
				continue;
			}
			else {
				sum[i] = Math.max(sum[i+1], arr[i][1]+sum[i+arr[i][0]]);
			}
		}
		
		System.out.println(sum[0]);
		
	}
	
	
}