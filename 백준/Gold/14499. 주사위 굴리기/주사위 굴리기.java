import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int sang, ha, dong, seo, nam, buk;
    static int[][] pan;
    static int N, M, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pan = new int[N][M];

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int n = 0 ; n < N ; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0 ; m < M ; m++){
                pan[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++){
            int dir = Integer.parseInt(st.nextToken());
            if(dir == 1){
                if(C == M-1) continue;
                C++;
            }
            else if(dir == 2){
                if(C == 0) continue;
                C--;
            }
            else if(dir == 3){
                if(R == 0) continue;
                R--;
            }
            else if(dir == 4){
                if(R == N-1) continue;
                R++;
            }
            Move(dir);
            if(pan[R][C] == 0){
                pan[R][C] = ha;
            }
            else{
                ha = pan[R][C];
                pan[R][C] = 0;
            }
            System.out.println(sang);
        }

    }

    static void Move(int dir){
        int tmp;
        if(dir == 1){
            tmp = dong; dong = sang; sang = seo; seo = ha; ha = tmp;
        }
        else if(dir == 2){
            tmp = seo; seo = sang; sang = dong; dong = ha; ha = tmp;
        }
        else if(dir == 3){
            tmp = buk; buk = sang; sang = nam; nam = ha; ha = tmp;
        }
        else if(dir == 4){
            tmp = nam; nam = sang; sang = buk; buk = ha; ha = tmp;
        }

    }
}