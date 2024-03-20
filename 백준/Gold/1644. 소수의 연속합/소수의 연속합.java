import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[] era = new boolean[4000000];
        
        for(int i = 2 ; i <= 2000 ; i++) {
            if(era[i]) continue;
            int j = 2;
            while(i*j < 4000000) {
                era[i*j] = true;
                j++;
            }
        }
        era[0] = true;
        era[1] = true;
        
        int[] p = new int[283147];
        
        int idx = 0;
        for(int i = 0 ; i < 4000000 ; i++) {
            if(!era[i]) {
                p[idx++] = i;
            }
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while(end <= 283146) {
        	if(sum < N) {
        		sum += p[end];
        		end++;
        	}
        	else if(sum == N) {
        		cnt++;
        		sum += p[end];
        		end++;
        	}
        	else {
        		sum -= p[start];
        		start++;
        	}
        }
        System.out.println(cnt);
    }
}