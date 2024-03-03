import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] arr;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int cnt;
		
		for(int ti = 1 ; ti <= t ; ti++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new boolean[N+1][N+1];
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				arr[p1][p2] = true;
				arr[p2][p1] = true;
			}
			
			onePerson:
			for(int r = 1 ; r <= N ; r++) {
				for(int c = 1 ; c <= N ; c++) {
					if(arr[r][c]) {
						continue onePerson;
					}
				}
				cnt++;
			}
			
			for(int r = 1 ; r <= N ; r++) {
				for(int c = 1 ; c <= N ; c++) {
					if(arr[r][c]) {
						dfs(r);
						cnt++;
						break;
					}
				}
			}
			
			
			System.out.println("#"+ti+" "+cnt);
		}
	}
	
	public static void dfs(int r) {
		for(int c = 1 ; c <= N ; c++) {
			if(arr[r][c]) {
				arr[r][c] = false;
				arr[c][r] = false;
				dfs(c);
			}
		}
	}
}