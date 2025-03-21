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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        int max = 0;

        for(int r = 0 ; r < n ; r++){
            String str = br.readLine();
            for(int c = 0 ; c < m ; c++) {
                map[r][c] = str.charAt(c)-'0';
                if (r == 0 || c == 0) {
                    dp[r][c] = map[r][c];
                    if(dp[r][c] > max) max = dp[r][c];
                }
            }
        }

        for(int r = 1 ; r < n ; r++) {
            for (int c = 1 ; c < m ; c++) {
                if(map[r][c] == 0){
                    dp[r][c] = 0;
                    continue;
                }

                int left = dp[r][c-1];
                int up = dp[r-1][c];

                if(left == up){
                    if(map[r-left][c-left] == 1){
                        dp[r][c] = left+1;
                    }
                    else{
                        dp[r][c] = left;
                    }
                }
                else{
                    dp[r][c] = Math.min(left, up) + 1;
                }

                if(dp[r][c] > max) max = dp[r][c];
            }
        }

        System.out.println(max*max);
    }
}