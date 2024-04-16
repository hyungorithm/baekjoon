import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Integer> que = new LinkedList<>();
	static boolean[][] arr = new boolean[8][8];
	static boolean[][] visit = new boolean[8][8];
	static int[] dr = {-1,0,1,0,-1,-1,1,1,0};
	static int[] dc = {0,-1,0,1,-1,1,-1,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int r = 0 ; r < 8 ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < 8 ; c++) {
				if(str.charAt(c) == '#') arr[r][c] = true;
			}
		}
		
		que.add(7); que.add(0);
		visit[7][0] = true;
		BFS();
		
	}

	private static void BFS() {
		while(!que.isEmpty()) {
			
			int size = que.size()/2;
			for(int i = 0 ; i < size ; i++) {
				int r = que.poll();
				int c = que.poll();
				visit[r][c] = false;
				
				if(r==0 && c==7) {
					System.out.println(1);
					return;
				}
				
				if(arr[r][c]) continue;
				
				for(int d = 0 ; d < 9 ; d++) {
					if(r+dr[d] >= 0 && r+dr[d] < 8 && c+dc[d] >= 0 && c+dc[d] < 8 && !visit[r+dr[d]][c+dc[d]] && !arr[r+dr[d]][c+dc[d]]) {
						visit[r+dr[d]][c+dc[d]] = true;
						que.add(r+dr[d]);
						que.add(c+dc[d]);
					}
				}
			}
			move();
		}
		System.out.println(0);
	}

	private static void move() {
		for(int r = 7 ; r >= 1 ; r--) {
			for(int c = 0 ; c < 8 ; c++) {
				arr[r][c] = arr[r-1][c];
			}
		}
		for(int c = 0 ; c < 8 ; c++) {
			arr[0][c] = false;
		}
	}
}
