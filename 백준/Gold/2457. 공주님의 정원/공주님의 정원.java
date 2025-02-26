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
            int t3 = Integer.parseInt(st.nextToken());
            int t4 = Integer.parseInt(st.nextToken());

            arr[i][0] = t1*100 + t2;
            arr[i][1] = t3*100 + t4;
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0]-o2[0];
        });

        int start = 301;
        int idx = 0;
        int max;
        int cnt = 0;

        while(start < 1131){
            cnt++;

            max = 0;
            while(idx < N && arr[idx][0] <= start){
                if(arr[idx][1] > max){
                    max = arr[idx][1];
                }
                idx++;
            }
            if(max == 0){
                System.out.println(0);
                return;
            }

            start = max;
        }
        
        if(start < 1131){
            System.out.println(0);
        }
        else{
            System.out.println(cnt);
        }
    }
}