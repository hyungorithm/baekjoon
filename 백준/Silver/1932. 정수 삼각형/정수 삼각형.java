import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] sum = new int[n][n];
        
        for(int r = 0 ; r < n ; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c = 0 ; c <= r ; c++) {
        		arr[r][c] = Integer.parseInt(st.nextToken());
        	}
        }
        
        sum[0][0] = arr[0][0];
        
        for(int r = 1 ; r < n ; r++) {
        	for(int c = 0 ; c <= r ; c++) {
        		if(c==0) {
        			sum[r][c] = sum[r-1][c] + arr[r][c];
        		}
        		else if(c==r) {
        			sum[r][c] = sum[r-1][c-1] + arr[r][c];
        		}
        		else {
        			sum[r][c] = Math.max(sum[r-1][c-1], sum[r-1][c]) + arr[r][c];
        		}
        	}
        }
        
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
        	if(sum[n-1][i] > max) {
        		max = sum[n-1][i];
        	}
        }
        
        System.out.println(max);
    }

}