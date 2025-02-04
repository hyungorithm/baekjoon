import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0) continue;

            int tmpMax = 0;
            for(int j = 0 ; j < i ; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[j] > tmpMax) {
                        tmpMax = dp[j];
                    }
                }
            }

            dp[i] = tmpMax +1;
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++) {
            if(dp[i] > ans) {
                ans = dp[i];
            }
        }

        int cnt = ans;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1 ; i >= 0 ; i--) {
            if(dp[i] == cnt){
                stack.add(arr[i]);
                cnt--;
            }
        }

        for(int i = 0 ; i < ans ; i++){
            sb.append(stack.pop());
            sb.append(" ");
        }

        System.out.println(ans);
        System.out.println(sb);

    }
}