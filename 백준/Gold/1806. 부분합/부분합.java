import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long tmp = 0;
        int start = 0;
        int end = 0;
        int size = Integer.MAX_VALUE;
        
        while(end <= N) {
//        	System.out.println(start+" "+end+" "+tmp);
        	if(tmp < S) {
        		if(end == N) break;
        		tmp += arr[++end];
        	}
        	else {
        		if(end-start < size) {
        			size = end-start;
        		}
        		tmp -= arr[++start];
        	}
        }
        
        if(size == Integer.MAX_VALUE) size = 0;
        System.out.println(size);
    }
}
