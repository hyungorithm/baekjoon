import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[][] arr;
	static boolean[][] visit;
	static Queue<Integer> que = new LinkedList<>();
	static Queue<Integer> zero = new LinkedList<>();
	static Queue<Integer> check = new LinkedList<>();
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][M];
		visit = new boolean[N][M];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < M ; c++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp > 0) {
					arr[r][c] = true;
					que.add(tmp);
					que.add(r);
					que.add(c);
				}
			}
		}
		
		int count = 0;
		while(!que.isEmpty()) {
			count++;
			melt();
			if(que.isEmpty()) {
				System.out.println(0);
				return;
			}
			
			int size = que.size()/3;
			int h = que.poll();
			int qr = que.poll();
			int qc = que.poll();
			
			check.add(qr);
			check.add(qc);
			
			visit = new boolean[N][M];
			
			int cnt = 0;
			
			visit[qr][qc] = true;
			cnt++;
			while(!check.isEmpty()) {
				int r = check.poll();
				int c = check.poll();
				for(int d = 0 ; d < 4 ; d++) {
					if(arr[r+dr[d]][c+dc[d]] && !visit[r+dr[d]][c+dc[d]]) {
						visit[r+dr[d]][c+dc[d]] = true;
						check.add(r+dr[d]);
						check.add(c+dc[d]);
						cnt++;
					}
				}
			}
			if(cnt != size) {
				System.out.println(count);
				return;
			}
			
			que.add(h);
			que.add(qr);
			que.add(qc);
		}
		
		
	}
	
	public static void melt() {
		int size = que.size()/3;
		
		loop:
		for(int i = 0 ; i < size ; i++) {
			int h = que.poll();
			int r = que.poll();
			int c = que.poll();
			for(int d = 0 ; d < 4 ; d++) {
				if(!arr[r+dr[d]][c+dc[d]]) {
					h--;
					if(h == 0) {
						zero.add(r);
						zero.add(c);						
						continue loop;
					}
				}
			}
			que.add(h);
			que.add(r);
			que.add(c);
		}
		
		while(!zero.isEmpty()) {
			int r = zero.poll();
			int c = zero.poll();
			arr[r][c] = false;
		}
	}
}
