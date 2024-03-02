import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int N, M, K;
		boolean[][] active;
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		Queue<int[]> que = new LinkedList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] > o2[2] ? -1 : 1;
			}
		});
		
		for(int ti = 1 ; ti <= t ; ti++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			active = new boolean[N+K][M+K];
			
			int tmp;
			for(int r = K/2 ; r < K/2+N ; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = K/2 ; c < K/2+M ; c++) {
					tmp = Integer.parseInt(st.nextToken());
					if(tmp > 0) {
						active[r][c] = true;
						pq.add(new int[] {r,c,tmp,1,1}); // r, c, life, count, active
					}
				}
			}
			
			for(int ki = 0 ; ki < K ; ki++) {
				int size = pq.size();
				for(int i = 0 ; i < size ; i++) {
					que.add(pq.poll());
				}
				
				for(int i = 0 ; i < size ; i++) {
					if(que.peek()[4] == 1) {
						if(que.peek()[2] > que.peek()[3]) {
							que.peek()[3]++;
							pq.add(que.poll());
						}
						else if(que.peek()[2] == que.peek()[3]) {
							que.peek()[3] = 1;
							que.peek()[4] = 2;
							pq.add(que.poll());
						}
					}
					else if(que.peek()[4] == 2) {
						for(int d = 0 ; d < 4 ; d++) {
							if(!active[que.peek()[0]+dr[d]][que.peek()[1]+dc[d]]) {
								pq.add(new int[] {que.peek()[0]+dr[d],que.peek()[1]+dc[d],que.peek()[2],1,1});
								active[que.peek()[0]+dr[d]][que.peek()[1]+dc[d]] = true;
							}
						}
						if(que.peek()[2] == que.peek()[3]) {
							que.poll();
						}
						else {
							que.peek()[3]++;
							pq.add(que.poll());
						}
					}
				}
			}
			System.out.println("#"+ti+" "+pq.size());
			pq.clear();
		}
	}
}