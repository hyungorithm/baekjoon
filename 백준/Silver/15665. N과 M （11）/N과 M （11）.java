import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static Set<Integer> set = new HashSet<>();
	public static int[] arr;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		nm(0);
		bw.flush();
		bw.close();
	}
	
	public static void nm(int depth) throws IOException {
		if(depth == m) {
			for(int i = 0 ; i < m ; i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int key : set) {
			arr[depth] = key;
			
			nm(depth + 1);
			
			arr[depth] = 0;
		}
	}
	
}
