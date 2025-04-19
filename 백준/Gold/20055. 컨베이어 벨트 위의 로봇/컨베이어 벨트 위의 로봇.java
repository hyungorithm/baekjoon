import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] pan = new int[N*2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N*2 ; i++){
            pan[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int loop = 0;
        int tmp = 0;

        while(cnt < K){
            loop++;
            tmp = pan[N*2 - 1];
            for(int i = N*2 - 1 ; i > 0 ; i--){
                pan[i] = pan[i-1];
            }
            pan[0] = tmp;

            if(pan[N-1] > 9999){
                pan[N-1] -= 10000;
            }

            for(int i = N-2 ; i >= 0 ; i--){
                if(pan[i] > 9999 && pan[i+1] > 0 && pan[i+1] < 9999){
                    pan[i] -= 10000;
                    pan[i+1] += 9999;

                    if(pan[i+1] == 10000){
                        cnt++;
                    }
                }
            }

            if(pan[N-1] > 9999){
                pan[N-1] -= 10000;
            }

            if(pan[0] > 0){
                pan[0] += 9999;
                if(pan[0] == 10000){
                    cnt++;
                }
            }
        }
        System.out.println(loop);
    }
}