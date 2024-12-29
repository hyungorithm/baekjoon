import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] block = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < W ; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int tmp = -1;
		
		for(int r = 1 ; r <= H ; r++) {
			tmp = -1;
			for(int c = 0 ; c < W ; c++) {
				if(r > block[c]) {
					if(tmp < 0) continue;
					tmp++;
				}
				else {
					if(tmp > 0) cnt += tmp;
					tmp = 0;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}