import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] set = new boolean[1000001];
		for(int i = 2 ; i <= 1000 ; i++) {
			int j = 2;
			if(set[i])
				continue;
			while(i*j <= 1000000) {
				set[i*j] = true;
				j++;
			}
		}
		set[1] = true;
		
		int t = Integer.parseInt(br.readLine());
		for (int tt = 0 ; tt < t ; tt++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i = 2 ; i <= n/2 ; i++) {
				if(!set[i]) {
					if(!set[n-i])
						cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}
