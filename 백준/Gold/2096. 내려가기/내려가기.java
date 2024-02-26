import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < 3 ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		max[0][0] = arr[0][0];
		max[0][1] = arr[0][1];
		max[0][2] = arr[0][2];
		
		min[0][0] = arr[0][0];
		min[0][1] = arr[0][1];
		min[0][2] = arr[0][2];
		
		for(int r = 1 ; r < N ; r++) {
			max[r][0] = Math.max(max[r-1][0], max[r-1][1]) + arr[r][0];
			max[r][1] = Math.max(Math.max(max[r-1][0], max[r-1][1]), max[r-1][2]) + arr[r][1];
			max[r][2] = Math.max(max[r-1][1], max[r-1][2]) + arr[r][2];
			
			min[r][0] = Math.min(min[r-1][0], min[r-1][1]) + arr[r][0];
			min[r][1] = Math.min(Math.min(min[r-1][0], min[r-1][1]), min[r-1][2]) + arr[r][1];
			min[r][2] = Math.min(min[r-1][1], min[r-1][2]) + arr[r][2];
		}
		
		System.out.println(Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2]) + " " + Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]));
		
	}
}
