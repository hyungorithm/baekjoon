import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static Map<Integer, Integer> map = new HashMap<>();
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
			int tk = Integer.parseInt(st.nextToken());
			if(map.containsKey(tk)) {
				map.put(tk, map.get(tk) + 1);
			}
			else {
				map.put(tk, 1);
			}
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
		
		for(int key : map.keySet()) {
			if((depth == 0 || key >= arr[depth-1]) && map.get(key) > 0) {
				arr[depth] = key;
				map.put(key, map.get(key) - 1);
				
				nm(depth + 1);
				
				map.put(key, map.get(key) + 1);
				arr[depth] = 0;
			}
		}
	}
	
}
