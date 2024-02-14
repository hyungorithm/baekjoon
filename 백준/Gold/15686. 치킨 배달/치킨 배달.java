import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static int x;
	public static int[] house;
	public static int[] chick;
	public static int[][] distance;
	public static boolean[] visit;
	
	public static int min = Integer.MAX_VALUE;
	public static int sum = 0;
	
	public static int houseC = 0;
	public static int chickC = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		house = new int[n*4];
		chick = new int[26];
		
		for(int r = 0 ; r < n ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < n ; c++) {
				x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					house[houseC++] = r;
					house[houseC++] = c;
				}
				else if(x == 2) {
					chick[chickC++] = r;
					chick[chickC++] = c;
				}
			}
		}
		
		distance = new int[chickC/2][houseC/2];
		
		for(int ci = 0 ; ci < chickC ; ci += 2) {
			for(int hi = 0 ; hi < houseC ; hi += 2) {
				distance[ci/2][hi/2] = Math.abs(chick[ci] - house[hi]) + Math.abs(chick[ci+1] - house[hi+1]);
			}
		}
		
		visit = new boolean[chickC/2];
		
		if(chickC/2 > 2*m) {
			rtb(0,0);
		}
		else {
			btr(0,0);
		}
		System.out.println(min);
		
	}
	
	public static void btr(int depth, int idx) {
		if(depth == chickC/2 - m) {
			for(int c = 0 ; c < houseC/2 ; c++) {
				int partMin = Integer.MAX_VALUE;
				for(int r = 0 ; r < chickC/2 ; r++) {
					if(!visit[r]) {
						if(distance[r][c] < partMin) {
							partMin = distance[r][c];
						}
					}
				}
				sum += partMin;
				partMin = 0;
			}
			
			if(sum < min) {
				min = sum;
			}
			sum = 0;
			return;
		}
		
		for(int i = idx ; i < chickC/2 ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				btr(depth+1, idx+1);
				visit[i] = false;
			}
		}
	}
	
	
	public static void rtb(int depth, int idx) {
		if(depth == m) {
			for(int c = 0 ; c < houseC/2 ; c++) {
				int partMin = Integer.MAX_VALUE;
				for(int r = 0 ; r < chickC/2 ; r++) {
					if(visit[r]) {
						if(distance[r][c] < partMin) {
							partMin = distance[r][c];
						}
					}
				}
				sum += partMin;
				partMin = 0;
			}
			
			if(sum < min) {
				min = sum;
			}
			sum = 0;
			return;
		}
		
		for(int i = idx ; i < chickC/2 ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				rtb(depth+1, idx+1);
				visit[i] = false;
			}
		}
	}
	
}
