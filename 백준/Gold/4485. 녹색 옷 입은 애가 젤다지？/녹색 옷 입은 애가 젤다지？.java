import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static int[][] graph;
    static int[][] min;
    static int N;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;

        while(true) {
            cnt++;
            N = Integer.parseInt(br.readLine());
            if(N==0) return;
            graph = new int[N][N];
            min = new int[N][N];

            for(int r = 0 ; r < N ; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < N ; c++){
                    graph[r][c] = Integer.parseInt(st.nextToken());
                    min[r][c] = 99999999;
                }
            }

            min[0][0] = graph[0][0];
            que.add(0);
            que.add(0);
            BFS();
            System.out.println("Problem " + cnt + ": " + min[N-1][N-1]);
        }
    }

    static void BFS() {
        while(!que.isEmpty()){
            int size = que.size()/2;
            for(int i = 0 ; i < size ; i++){
                int r = que.poll();
                int c = que.poll();
                for(int d = 0 ; d < 4 ; d++){
                    if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && min[r][c] + graph[r+dr[d]][c+dc[d]] < min[r+dr[d]][c+dc[d]]){
                        min[r+dr[d]][c+dc[d]] = min[r][c] + graph[r+dr[d]][c+dc[d]];
                        que.add(r+dr[d]);
                        que.add(c+dc[d]);
                    }
                }
            }
        }
    }
}