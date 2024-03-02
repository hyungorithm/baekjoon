import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, left, right;
	static int[] arr;
	static boolean[] visit;
	static int sum, cnt;
	static int[] fact = {1,2,8,48,384,3840,46080,645120,10321920,185794560};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int ti = 1 ; ti <= t ; ti++) {
			cnt = 0; sum = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			visit = new boolean[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			select(0);
			System.out.println("#"+ti+" "+cnt);
		}
	}
	
	public static void select(int depth) {
		if(left >= (sum+1)/2) {
			cnt += fact[n-depth];
			return;
		}
		
		if(right > left) {
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				left += arr[i];
				select(depth+1);
				left -= arr[i];
				visit[i] = false;
				
				visit[i] = true;
				right += arr[i];
				select(depth+1);
				right -= arr[i];
				visit[i] = false;
			}
		}
	}
	
}