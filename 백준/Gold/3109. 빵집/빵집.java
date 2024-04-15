import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] arr;
	static int[] dr = {-1,0,1};
	static int cnt;
	static boolean ok;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		
		for(int r = 0 ; r < R ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < C ; c++) {
				arr[r][c] = str.charAt(c)-46;
			}
		}
		
		for(int r = 0 ; r < R ; r++) {
			ok = false;
			DFS(r, 0);
		}
		
//		for(int r = 0 ; r < R ; r++) {
//			for(int c = 0 ; c < C ; c++) {
//				System.out.print(arr[r][c]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(cnt);
	}

	private static void DFS(int r, int c) {
		arr[r][c] = 1;
		
		if(c == C-1) {
			cnt++;
			ok = true;
			return;
		}
		
		for(int d = 0 ; d < 3 ; d++) {
			if(r+dr[d] >= 0 && r+dr[d] < R && arr[r+dr[d]][c+1] == 0) {
				DFS(r+dr[d], c+1);
				if(ok) return;
			}
		}
	}
	
	
}
