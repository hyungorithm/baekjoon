import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            arr[i][0] = t1;
            arr[i][1] = t2;
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0]-o2[0];
        });

        int sum;
        int now;

        sum = arr[0][1] - arr[0][0];
        now = arr[0][1];

        for(int i = 1 ; i < N ; i++){
            sum += Math.max(0, arr[i][1] - Math.max(now, arr[i][0]));
            now = Math.max(now, arr[i][1]);
        }

        System.out.println(sum);
    }
}