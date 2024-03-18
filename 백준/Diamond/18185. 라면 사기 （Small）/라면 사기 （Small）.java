import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = 0;
        int cnt = 0;
        while(idx < N-2) {
        	if(arr[idx] == 0) {
        		idx++;
        	}
        	else if(arr[idx+1] == 0) {
        		cnt += arr[idx]*3;
        		arr[idx] = 0;
        		idx += 2;
        	}
        	else if(arr[idx+2] == 0) {
        		cnt += Math.min(arr[idx], arr[idx+1])*5;
        		cnt += (Math.max(arr[idx], arr[idx+1]) - Math.min(arr[idx], arr[idx+1]))*3;
        		arr[idx] = 0;
        		arr[idx+1] = 0;
        		idx += 3;
        	}
        	else {
        		if(arr[idx] < arr[idx+1] && arr[idx+2] < arr[idx+1]) {
        			if(arr[idx] < arr[idx+1] - arr[idx+2]) {
        				cnt += arr[idx]*5;
        				arr[idx+1] -= arr[idx];
        				arr[idx] = 0;
        				idx++;
        			}
        			else {
        				cnt += (arr[idx+1] - arr[idx+2])*5;
        				arr[idx] -= (arr[idx+1] - arr[idx+2]);
        				arr[idx+1] = arr[idx+2];
        			}
        		}
        		else if(arr[idx] <= arr[idx+1] && arr[idx] <= arr[idx+2]) {
        			cnt += arr[idx]*7;
        			arr[idx+1] -= arr[idx];
        			arr[idx+2] -= arr[idx];
        			arr[idx] = 0;
        			idx++;
        		}
        		else if(arr[idx+1] <= arr[idx] && arr[idx+1] <= arr[idx+2]) {
        			cnt += arr[idx+1]*7;
        			arr[idx] -= arr[idx+1];
        			arr[idx+2] -= arr[idx+1];
        			
        			cnt += arr[idx]*3;
        			arr[idx+1] = 0;
        			arr[idx] = 0;
        			idx += 2;
        		}
        		else {
        			cnt += arr[idx+2]*7;
        			arr[idx] -= arr[idx+2];
        			arr[idx+1] -= arr[idx+2];
        			
        			cnt += Math.min(arr[idx], arr[idx+1])*5;
            		cnt += (Math.max(arr[idx], arr[idx+1]) - Math.min(arr[idx], arr[idx+1]))*3;
            		arr[idx] = 0;
            		arr[idx+1] = 0;
            		arr[idx+2] = 0;
            		idx += 3;
        		}
        	}
        }
        
        if(idx == N-2) {
        	cnt += Math.min(arr[idx], arr[idx+1])*5;
    		cnt += (Math.max(arr[idx], arr[idx+1]) - Math.min(arr[idx], arr[idx+1]))*3;
    		arr[idx] = 0;
    		arr[idx+1] = 0;
        }
        if(idx == N-1) {
        	cnt += arr[idx]*3;
        	arr[idx] = 0;
        }
        
        System.out.println(cnt);
        
    }
}