import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int[] sik = {1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0,9};
	static int[] ten = {1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		for(int ti = 0 ; ti < T ; ti++) {
			N = Integer.parseInt(br.readLine());
			BTR(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void BTR(int depth) {
		if(depth == N) {
			int sum = 0;
			int tmp = 0;
			int bnk = 1;
			
			tmp += N;
			for(int i = N*2 - 4 ; i >= 0 ; i -= 2) {
				if(sik[i+1] == ' ') {
					tmp += sik[i] * ten[bnk];
					bnk++;
				}
				else if(sik[i+1] == '+') {
					sum += tmp;
					tmp = sik[i];
					bnk = 1;
				}
				else if(sik[i+1] == '-') {
					sum -= tmp;
					tmp = sik[i];
					bnk = 1;
				}
			}
			sum += tmp;
			
			if(sum == 0) {
				for(int i = 0 ; i <= N*2 - 2 ; i++) {
					if(sik[i] < 10) {
						sb.append(sik[i]);
					}
					else {
						sb.append((char)sik[i]);
					}
				}
				sb.append("\n");
			}
			return;
		}
		
		sik[depth*2 - 1] = ' ';
		BTR(depth+1);
		sik[depth*2 - 1] = '+';
		BTR(depth+1);
		sik[depth*2 - 1] = '-';
		BTR(depth+1);
	}
	
	
}