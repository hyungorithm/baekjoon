import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] select;
	static boolean[] garySelect;
	static int[] people;
	static boolean[][] link;
	
	static int cnt1 = 0;
	static int cnt2 = 0;
	static int cnt3 = 0;
	static int cnt4 = 0;
	static int min = 987654321;
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		link = new boolean[N+1][N+1];
		select = new boolean[N+1];
		garySelect = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int r = 1 ; r <= N ; r++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < M ; i++) {
				int c = Integer.parseInt(st.nextToken());
				link[r][c] = true;
			}
		}
		
		comb(1);
		if(min == 987654321) min = -1;
		System.out.println(min);
	}
	
	static void comb(int depth) {
		if(depth == N+1) {
			if(cnt1 == N || cnt2 == N) return;
			gary();
			return;
		}
		
		select[depth] = true;
		cnt1++;
		comb(depth+1);
		cnt1--;
		
		select[depth] = false;
		cnt2++;
		comb(depth+1);
		cnt2--;
	}

	static void gary() {
		Arrays.fill(garySelect, false);
		cnt3 = 0;
		cnt4 = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			if(select[i]) {
				que.add(i);
				garySelect[i] = true;
				cnt3++;
				break;
			}
		}
		
		while(!que.isEmpty()) {
			int e = que.poll();
			for(int i = 1 ; i <= N ; i++) {
				if(link[e][i] && !garySelect[i] && select[i]) {
					que.add(i);
					garySelect[i] = true;
					cnt3++;
				}
			}
		}
		
		if(cnt1 != cnt3) return;
		
		for(int i = 1 ; i <= N ; i++) {
			if(!select[i]) {
				que.add(i);
				garySelect[i] = true;
				cnt4++;
				break;
			}
		}
		
		while(!que.isEmpty()) {
			int e = que.poll();
			for(int i = 1 ; i <= N ; i++) {
				if(link[e][i] && !garySelect[i] && !select[i]) {
					que.add(i);
					garySelect[i] = true;
					cnt4++;
				}
			}
		}
		
		if(cnt2 != cnt4) return;
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(select[i]) sum1 += people[i];
			else sum2 += people[i];
		}
		if(min > Math.abs(sum1 - sum2)) min = Math.abs(sum1 - sum2);
		
	}
}
