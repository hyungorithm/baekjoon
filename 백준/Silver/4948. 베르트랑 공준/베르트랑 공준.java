import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = -1;
		while(n!=0) {
			int cnt = 0;
			n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			for(int i = n+1 ; i <= 2*n ; i++) {
				boolean p = true;
				if(i==2||i==3) {
					cnt++;
					continue;
				}
				for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
					if(i%j==0) {
						p = false;
						break;
					}
				}
				if(p)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
