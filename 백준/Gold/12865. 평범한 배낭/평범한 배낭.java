import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] item = new int[N+1][2];
		int[][] bag = new int[K+1][N+1];
		
		
		for(int i = 1 ; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int ki = 1 ; ki <= K ; ki++) {
			for(int i = 1 ; i <= N ; i++) {
				bag[ki][i] = Math.max(bag[ki-1][i], bag[ki][i-1]);
				if(item[i][0] <= ki) {
					bag[ki][i] = Math.max(bag[ki][i], item[i][1] + bag[ki-item[i][0]][i-1]);
				}
			}
		}
		
//		for(int r = 1 ; r <= K ; r++) {
//			for(int c = 1 ; c <= N ; c++) {
//				System.out.print(bag[r][c]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(bag[K][N]);
		
	}
	
}