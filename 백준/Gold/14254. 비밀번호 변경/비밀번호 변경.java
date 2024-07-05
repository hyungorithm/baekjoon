import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int K = Integer.parseInt(br.readLine());
        int max = 0;
        int cnt = 0;
        int ans = 0;

        int[] abc = new int[26];

        for(int i = 0 ; i < len-K ; i++){
            Arrays.fill(abc, 0);
            max = 0;
            cnt = 0;
            for(int j = i ; j < len ; j += len-K){
                abc[str.charAt(j)-'a']++;
                cnt++;
                if(abc[str.charAt(j)-'a'] > max){
                    max = abc[str.charAt(j)-'a'];
                }
            }
            ans += cnt - max;
        }

        System.out.println(ans);
    }
}