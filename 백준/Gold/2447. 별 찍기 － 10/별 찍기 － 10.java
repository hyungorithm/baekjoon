import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		
		star(1, n);
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c < n ; c++) {
				if(map[r][c])
					bw.write(" ");
				else
					bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}
	
	public static void star (int depth, int n) throws IOException {
		if(n==1)
			return;
		
		for(int r = 0 ; r < n*depth ; r++) {
			for(int c = 0 ; c < n*depth ; c++) {
				if(r/(n/3) %3 == 1 && c/(n/3) %3 == 1) {
					map[r][c] = true;
				}
			}
		}
		
		depth *= 3;
		star(depth, n/3);
	}
}
