import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		p = new int[G+1];
		for(int i = 1 ; i <= G ; i++) {
			p[i] = i;
		}
		
		int P = Integer.parseInt(br.readLine());
		int cnt;
		for(cnt = 0 ; cnt < P ; cnt++) {
			int num = Integer.parseInt(br.readLine());
			int fs = findSet(p[num]);
			if(fs == 0) break;
			
			p[fs]--;
		}
		System.out.println(cnt);
	}
	
	static int findSet(int idx) {
		if(idx != p[idx]) {
			p[idx] = findSet(p[idx]);
		}
		return p[idx];
	}
}
