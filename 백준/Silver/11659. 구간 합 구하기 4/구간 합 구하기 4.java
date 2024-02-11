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
		
		int[] arr = new int[n];
		int[] sum = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0)
				sum[i] = arr[i];
			else
				sum[i] = sum[i-1] + arr[i];
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			
			if(ii == 1)
				System.out.println(sum[jj-1]);
			else
				System.out.println(sum[jj-1] - sum[ii-2]);
		}
		
	}
}