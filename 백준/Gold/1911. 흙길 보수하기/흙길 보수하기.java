import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] woong = new int[N*2];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            woong[i*2] = Integer.parseInt(st.nextToken());
            woong[i*2+1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(woong);

        int cnt = 0;
        int ptr = 0;

        for(int i = 0 ; i < N ; i++){
            int now = Math.max(ptr, woong[i*2]);
            int now_cnt = (woong[i*2+1] - now) / L;
            if((woong[i*2+1] - now) % L > 0) now_cnt++;

            cnt += now_cnt;
            ptr = now + now_cnt * L;
        }

        System.out.println(cnt);
    }
}