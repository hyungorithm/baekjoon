import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int input;
	static int index;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        
        for(int i = 0 ; i < N ; i++) {
        	input = Integer.parseInt(st.nextToken());
        	binary(0,cnt+1);

        	arr[index] = input;
        	if(index == cnt){
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
    
    static void binary(int left, int right) {
    	int mid;
    	
    	while(left < right) {
    		mid = (left + right) / 2;
    		if(arr[mid] < input) left = mid + 1;
    		else right = mid;
    	}
    	
    	index = right;
    }
}