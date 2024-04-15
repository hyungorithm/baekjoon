import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] choo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		choo = new int[N];
		
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			choo[i] = Integer.parseInt(st.nextToken());
			sum += choo[i];
		}
		
		boolean[] able = new boolean[sum+1];
		boolean[] tmp = new boolean[sum+1];
		
		for(int i = 0 ; i < N ; i++) {
			tmp = new boolean[sum+1];
			for(int j = 0 ; j <= sum ; j++) {
				if(able[j]) {
					tmp[Math.abs(j + choo[i])] = true;
					tmp[Math.abs(j - choo[i])] = true;
				}
			}
			for(int j = 0 ; j <= sum ; j++) {
				if(tmp[j]) able[j] = true;
			}
			able[choo[i]] = true;
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > sum) System.out.print("N ");
			else System.out.print(able[num]? "Y ":"N ");
		}
		
	}
}
