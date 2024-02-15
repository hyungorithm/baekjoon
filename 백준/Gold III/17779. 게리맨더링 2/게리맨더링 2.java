import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] A;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n][n];
		
		for(int r = 0 ; r < n ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < n ; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] people = {0,0,0,0,0};
		int min = Integer.MAX_VALUE;
		for(int x = 0 ; x < n-2 ; x++) {
			for(int y = 1 ; y < n-1 ; y++) {
				for(int d1 = 1 ; d1 < n-1 ; d1++) {
					for(int d2 = 1 ; d2 < n-1 ; d2++) {
						if(x+d1+d2 < n && y-d1 >= 0 && y+d2 < n) {
							Arrays.fill(people, 0);
							visit = new boolean[n][n];
							
							// 5구역 인구
							int left = 1; int right = -1;
							for(int r = 0 ; r <= d1+d2 ; r++) {
								if(r <= d1 && r <= d2) {
									left--; right++;
								}
								else if(r <= d1 && r > d2) {
									left--; right--;
								}
								else if(r > d1 && r <= d2) {
									left++; right++;
								}
								else {
									left++; right--;
								}
								for(int c = y + left ; c <= y + right  ; c++) {
									people[0] += A[x+r][c];
									visit[x+r][c] = true;
								}
							}
							int tmp_min = people[0];
							int tmp_max = people[0];
							
							// 1구역 인구
							for(int r = 0 ; r < x+d1 ; r++) {
								for(int c = 0 ; c < y+1 ; c++) {
									if(!visit[r][c]) {
										people[1] += A[r][c];
									}
								}
							}
							if(people[1] > tmp_max)
								tmp_max = people[1];
							if(people[1] < tmp_min)
								tmp_min = people[1];
							
							// 2구역 인구
							for(int r = 0 ; r < x+d2+1 ; r++) {
								for(int c = y+1 ; c < n ; c++) {
									if(!visit[r][c]) {
										people[2] += A[r][c];
									}
								}
							}
							if(people[2] > tmp_max)
								tmp_max = people[2];
							if(people[2] < tmp_min)
								tmp_min = people[2];
							
							// 3구역 인구
							for(int r = x+d1 ; r < n ; r++) {
								for(int c = 0 ; c < y-d1+d2 ; c++) {
									if(!visit[r][c]) {
										people[3] += A[r][c];
									}
								}
							}
							if(people[3] > tmp_max)
								tmp_max = people[3];
							if(people[3] < tmp_min)
								tmp_min = people[3];
							
							// 4구역 인구
							for(int r = x+d2+1 ; r < n ; r++) {
								for(int c = y-d1+d2 ; c < n ; c++) {
									if(!visit[r][c]) {
										people[4] += A[r][c];
									}
								}
							}
							if(people[4] > tmp_max)
								tmp_max = people[4];
							if(people[4] < tmp_min)
								tmp_min = people[4];
							
							
							if(tmp_max - tmp_min < min) {
								min = tmp_max - tmp_min;
							}
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}
}
