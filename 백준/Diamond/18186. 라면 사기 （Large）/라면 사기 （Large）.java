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
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(B <= C) {
        	long cnt = 0L;
        	for(int i = 0 ; i < N ; i++) {
        		cnt += B*arr[i];
        	}
        	System.out.println(cnt);
        	return;
        }
        int idx = 0;
        long cnt = 0L;
        while(idx < N-2) {
        	if(arr[idx] == 0) {
        		idx++;
        	}
        	else if(arr[idx+1] == 0) {
        		cnt += arr[idx]*B;
        		arr[idx] = 0;
        		idx += 2;
        	}
        	else if(arr[idx+2] == 0) {
        		cnt += Math.min(arr[idx], arr[idx+1])*(B+C);
        		cnt += (Math.max(arr[idx], arr[idx+1]) - Math.min(arr[idx], arr[idx+1]))*B;
        		arr[idx] = 0;
        		arr[idx+1] = 0;
        		idx += 3;
        	}
        	else {
        		if(arr[idx] < arr[idx+1] && arr[idx+2] < arr[idx+1]) {
        			if(arr[idx] < arr[idx+1] - arr[idx+2]) {
        				cnt += arr[idx]*(B+C);
        				arr[idx+1] -= arr[idx];
        				arr[idx] = 0;
        				idx++;
        			}
        			else {
        				cnt += (arr[idx+1] - arr[idx+2])*(B+C);
        				arr[idx] -= (arr[idx+1] - arr[idx+2]);
        				arr[idx+1] = arr[idx+2];
        			}
        		}
        		else if(arr[idx] <= arr[idx+1] && arr[idx] <= arr[idx+2]) {
        			cnt += arr[idx]*(B+2*C);
        			arr[idx+1] -= arr[idx];
        			arr[idx+2] -= arr[idx];
        			arr[idx] = 0;
        			idx++;
        		}
        		else if(arr[idx+1] <= arr[idx] && arr[idx+1] <= arr[idx+2]) {
        			cnt += arr[idx+1]*(B+2*C);
        			arr[idx] -= arr[idx+1];
        			arr[idx+2] -= arr[idx+1];
        			
        			cnt += arr[idx]*B;
        			arr[idx+1] = 0;
        			arr[idx] = 0;
        			idx += 2;
        		}
        		else {
        			cnt += arr[idx+2]*(B+2*C);
        			arr[idx] -= arr[idx+2];
        			arr[idx+1] -= arr[idx+2];
        			
        			cnt += Math.min(arr[idx], arr[idx+1])*(B+C);
            		cnt += (Math.max(arr[idx], arr[idx+1]) - Math.min(arr[idx], arr[idx+1]))*B;
            		arr[idx] = 0;
            		arr[idx+1] = 0;
            		arr[idx+2] = 0;
            		idx += 3;
        		}
        	}
        }
        
        if(idx == N-2) {
        	cnt += Math.min(arr[idx], arr[idx+1])*(B+C);
    		cnt += (Math.max(arr[idx], arr[idx+1]) - Math.min(arr[idx], arr[idx+1]))*B;
    		arr[idx] = 0;
    		arr[idx+1] = 0;
        }
        if(idx == N-1) {
        	cnt += arr[idx]*B;
        	arr[idx] = 0;
        }
        
        System.out.println(cnt);
        
    }
}