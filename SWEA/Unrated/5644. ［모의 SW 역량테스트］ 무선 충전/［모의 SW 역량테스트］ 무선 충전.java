import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int M, A;
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	static int[][] moveA;
	static int[][] moveB;
	static int[][] BC;
	
	static int score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int ti = 1 ; ti <= t ; ti++) {
			score = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			moveA = new int[M+1][2];
			moveB = new int[M+1][2];
			
			moveA[0][0] = 1; moveA[0][1] = 1;
			moveB[0][0] = 10; moveB[0][1] = 10; 
			
			st = new StringTokenizer(br.readLine());
			int R = 1; int C = 1;
			for(int i = 1 ; i <= M ; i++) {
				int d = Integer.parseInt(st.nextToken());
				R = R+dr[d]; C = C+dc[d];
				moveA[i][0] = R;
				moveA[i][1] = C;
			}
			
			st = new StringTokenizer(br.readLine());
			R = 10; C = 10;
			for(int i = 1 ; i <= M ; i++) {
				int d = Integer.parseInt(st.nextToken());
				R = R+dr[d]; C = C+dc[d];
				moveB[i][0] = R;
				moveB[i][1] = C;
			}
			
			BC = new int[A+1][4];
			for(int i = 1 ; i <= A ; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0 ; i <= M ; i++) {
				int[] maxA = new int[2];
				int[] maxB = new int[2];
				
				for(int j = 1 ; j <= A ; j++) {
					if(Math.abs(BC[j][0]-moveA[i][0]) + Math.abs(BC[j][1]-moveA[i][1]) <= BC[j][2]) {
						if(BC[j][3] > BC[maxA[0]][3]) {
							maxA[1] = maxA[0];
							maxA[0] = j;
						}
						else if(BC[j][3] > BC[maxA[1]][3]) {
							maxA[1] = j;
						}
					}
					if(Math.abs(BC[j][0]-moveB[i][0]) + Math.abs(BC[j][1]-moveB[i][1]) <= BC[j][2]) {
						if(BC[j][3] > BC[maxB[0]][3]) {
							maxB[1] = maxB[0];
							maxB[0] = j;
						}
						else if(BC[j][3] > BC[maxB[1]][3]) {
							maxB[1] = j;
						}
					}
				}
				
				if(maxA[0] == 0 && maxB[0] == 0) {
					continue;
				}
				
				else if(maxA[0] > 0 && maxB[0] == 0) {
					score += BC[maxA[0]][3];
				}
				
				else if(maxA[0] == 0 && maxB[0] > 0) {
					score += BC[maxB[0]][3];
				}
				
				else if(maxA[0] != maxB[0]) {
					score += BC[maxA[0]][3];
					score += BC[maxB[0]][3];
				}
				
				else if(maxA[1] == 0 && maxB[1] == 0) {
					score += BC[maxA[0]][3];
				}
				
				else if(maxA[1] > 0 && maxB[1] == 0) {
					score += BC[maxA[1]][3];
					score += BC[maxB[0]][3];
				}
				
				else if(maxA[1] == 0 && maxB[1] > 0) {
					score += BC[maxA[0]][3];
					score += BC[maxB[1]][3];
				}
				
				else {
					score += BC[maxA[0]][3];
					score += Math.max(BC[maxA[1]][3], BC[maxB[1]][3]);
				}
			}
			
			
			System.out.println("#"+ti+" "+score);
		}
	}
}