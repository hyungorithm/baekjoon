import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static int[] arr;
	public static int[] res;
	public static boolean[] visit;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[n];
		res = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < n-1 ; i++) {
			for(int j = 0 ; j < n-1-i ; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		nm(0);
		bw.flush();
		bw.close();

	}
	
	public static void nm(int depth) throws IOException {
		if(depth == m) {
			for(int i = 0 ; i < m ; i++) {
				bw.write(res[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				res[depth] = arr[i];
				nm(depth+1);
				visit[i] = false;
			}
		}
		
	}
}
