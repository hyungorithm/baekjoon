import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[N];
        int[] diff = new int[N-1];

        for(int i = 0 ; i < N ; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(origin);

        for(int i = 0 ; i < N-1 ; i++){
            diff[i] = origin[i+1] - origin[i];
        }

        Arrays.sort(diff);

        for(int i = 0 ; i < N - K ; i++){
            cnt += diff[i];
        }

        System.out.println(cnt);
    }
}