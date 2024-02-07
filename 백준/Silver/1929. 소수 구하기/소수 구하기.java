import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = m ; i <= n ; i++) {
			boolean isP = true;
			if (i==1) {
				continue;
			}
			if (i==2 || i==3) {
				System.out.println(i);
				continue;
			}
			for (int j = 2 ; j <= Math.sqrt(i) ; j++) {
				if (i%j==0) {
					isP = false;
					break;
				}
			}
			if (isP) {
				System.out.println(i);
				continue;
			}
		}
		
	}
}
