import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double N = Double.parseDouble(st.nextToken());
		double M = Double.parseDouble(st.nextToken());
		
		double div = N/M;
		int cnt = 0;

		for(int i = 1 ; i < M ; i++) {
			if(div*i % 1 > 0.00000001) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}