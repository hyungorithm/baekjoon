import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int able = 1;
		
		for(int r = 0 ; r < N ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c <= r ; c++) {
				arr[r][c] = str.charAt(c) - 'A';
			}
		}
		
		ableTest:
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c <= r ; c++) {
				if(arr[r][c] == 17) {
					if(r == N-1 || arr[r+1][c] != 17 || arr[r+1][c+1] != 17) {
						able = 0; break ableTest;
					}
					arr[r+1][c] = 0; arr[r+1][c+1] = 0;
				}
				else if(arr[r][c] == 1) {
					if(c == r || r == N-1 || arr[r][c+1] != 1 || arr[r+1][c+1] != 1) {
						able = 0; break ableTest;
					}
					arr[r][c+1] = 0; arr[r+1][c+1] = 0;
				}
			}
		}
		
		System.out.println(able);
	}
}
