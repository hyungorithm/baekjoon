import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sum = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i < n ; i++) {
			if(i == 0)
				sum[i] = arr[i];
			else
				sum[i] = sum[i-1] + arr[i];
		}
		
		int cnt = 0;
		for(int i = 0 ; i < n ; i++) {
			cnt += sum[i];
		}
		
		System.out.println(cnt);
		
	}
}
