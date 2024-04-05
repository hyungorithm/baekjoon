import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {-1,1,1,-1};
	static int d;
	
	static Set<Integer> set = new HashSet<>();
	
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int ti = 1 ; ti <= T ; ti++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int r = 0 ; r < N ; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0 ; c < N ; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = -1;
			find();
			System.out.println("#"+ti+" "+max);
		}
	}
	
	public static void find() {
		for(int r = 0 ; r < N-2 ; r++) {
			for(int c = 1 ; c < N-1 ; c++) {
				for(int d1 = 1 ; c-d1 >= 0 ; d1++) {
					loop:
					for(int d2 = 1 ; c+d2 < N ; d2++) {
						set.clear();
						
						d = 0;
						int R = r;
						int C = c;
						
						if(r+d1+d2 >= N) continue;
						for(int i = 0 ; i < d1 ; i++) {
							if(set.contains(arr[R][C])) continue loop;
							set.add(arr[R][C]);
							R = R+dr[d];
							C = C+dc[d];
						}
						d++;
						for(int i = 0 ; i < d2 ; i++) {
							if(set.contains(arr[R][C])) continue loop;
							set.add(arr[R][C]);
							R = R+dr[d];
							C = C+dc[d];
						}
						d++;
						for(int i = 0 ; i < d1 ; i++) {
							if(set.contains(arr[R][C])) continue loop;
							set.add(arr[R][C]);
							R = R+dr[d];
							C = C+dc[d];
						}
						d++;
						for(int i = 0 ; i < d2 ; i++) {
							if(set.contains(arr[R][C])) continue loop;
							set.add(arr[R][C]);
							R = R+dr[d];
							C = C+dc[d];
						}
						if(set.size() > max) max = set.size();
					}
				}
			}
		}
	}
}
