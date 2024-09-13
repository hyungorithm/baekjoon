import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[] dr22 = {0,0,1,1};
    static int[] dc22 = {0,1,0,1};
    static int[] dr41 = {0,1,2,3};
    static int[] dc41 = {0,0,0,0};
    static int[] dr32 = {0,1,2,2, 0,1,2,2, 0,0,1,2, 0,0,1,2, 0,1,1,2, 0,1,1,2, 0,1,1,2, 0,1,1,2};
    static int[] dc32 = {0,0,0,1, 1,1,1,0, 0,1,1,1, 1,0,0,0, 0,0,1,1, 1,1,0,0, 0,0,1,0, 1,1,0,1};

    static int max = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int r = 0 ; r < N ; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0 ; r < N ; r++){
            for(int c = 0 ; c < M ; c++){
                if(r < N-3){
                    cnt = 0;
                    for(int d = 0 ; d < 4 ; d++){
                        cnt += arr[r+dr41[d]][c+dc41[d]];
                    }
                    if(cnt > max) max = cnt;
                }
                if(c < M-3){
                    cnt = 0;
                    for(int d = 0 ; d < 4 ; d++){
                        cnt += arr[r+dc41[d]][c+dr41[d]];
                    }
                    if(cnt > max) max = cnt;
                }
                if(r < N-1 && c < M-1){
                    cnt = 0;
                    for(int d = 0 ; d < 4 ; d++){
                        cnt += arr[r+dr22[d]][c+dc22[d]];
                    }
                    if(cnt > max) max = cnt;
                }
                if(r < N-2 && c < M-1){
                    for(int t = 0 ; t < 32 ; t += 4){
                        cnt = 0;
                        for(int d = 0 ; d < 4 ; d++){
                            cnt += arr[r+dr32[d+t]][c+dc32[d+t]];
                        }
                        if(cnt > max) max = cnt;
                    }
                }
                if(r < N-1 && c < M-2){
                    for(int t = 0 ; t < 32 ; t += 4){
                        cnt = 0;
                        for(int d = 0 ; d < 4 ; d++){
                            cnt += arr[r+dc32[d+t]][c+dr32[d+t]];
                        }
                        if(cnt > max) max = cnt;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
