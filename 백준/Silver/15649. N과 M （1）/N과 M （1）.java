import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] visit;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		arr = new int[m];
		
		nm(0,m,n);
		
	}
	
	public static void nm(int depth, int m, int n) {
		if(depth == m) {
			for(int i = 0 ; i < m ; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				nm(depth+1, m, n);
				visit[i] = false;
			}
		}
	}
}
