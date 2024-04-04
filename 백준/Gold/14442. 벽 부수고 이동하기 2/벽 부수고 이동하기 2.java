import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K;
    public static int[][] arr;
    public static boolean[][][] road;
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,-1,0,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        road = new boolean[N][M][K+1];
        
        for(int r = 0 ; r < N ; r++) {
            String str = br.readLine();
            for(int c = 0 ; c < M ; c++) {
                arr[r][c] = str.charAt(c) - '0';
            }            
        }
        
        bfs();
    }

    private static void bfs() {
    	if(N==1 && M==1) {
			System.out.println(1);
			return;
		}
    	
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        que.add(0);
        road[0][0][0] = true;
        
        int cnt = 1;
        while(!que.isEmpty()) {
        	
            cnt++;
            int size = que.size()/3;
            for(int i = 0 ; i < size ; i++) {
                int r = que.poll();
                int c = que.poll();
                int h = que.poll();
                
                for(int d = 0 ; d < 4 ; d++) {
                    if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < M) {
                    	if(r+dr[d] == N-1 && c+dc[d] == M-1) {
                    		System.out.println(cnt);
                    		return;
                    	}
                    	if(arr[r+dr[d]][c+dc[d]] == 0 && !road[r+dr[d]][c+dc[d]][h]) {
                    		que.add(r+dr[d]); que.add(c+dc[d]); que.add(h);
                    		for(int z = h ; z <= K ; z++) {
                    			road[r+dr[d]][c+dc[d]][z] = true;                        		
                    		}
                    	}
                    	else if(arr[r+dr[d]][c+dc[d]] == 1 && h+1 <= K && !road[r+dr[d]][c+dc[d]][h+1]) {
                            que.add(r+dr[d]); que.add(c+dc[d]); que.add(h+1);
                            for(int z = h+1 ; z <= K ; z++) {
                    			road[r+dr[d]][c+dc[d]][z] = true;                        		
                    		}
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}