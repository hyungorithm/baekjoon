import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] visit;
	public static int n;
	public static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Byte.parseByte(br.readLine());
		visit = new int[n*2];
		
		nqueen(0);
		System.out.println(cnt);
	}
	
	public static void nqueen(int depth) {
		
		if(depth == n) {
			cnt++;
			return;
		}
		
		int r = depth;
		col:
			for(int c = 0 ; c < n ; c++) {
				for(int i = 0 ; i < depth ; i++) {
					if(c == visit[i*2+1] || r-c == visit[i*2] - visit[i*2+1] || r+c == visit[i*2] + visit[i*2+1]) {
						continue col;
					}
				}
				visit[depth*2] = r;
				visit[depth*2+1] = c;
				
				nqueen(depth+1);
				
			}
	}
}
