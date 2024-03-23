import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int plus = 0;
		int minus = 0;
		
		boolean first = false;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] >= 0 && !first) {
				if(i==0) {
					System.out.println(arr[i]+" "+Integer.parseInt(st.nextToken()));
					return;
				}
				first = true;
				plus = i; minus = i-1;
			}
		}
		if(!first) {
			System.out.println(arr[N-2]+" "+arr[N-1]);
			return;
		}
		
		int ans1 = arr[minus]; int ans2 = arr[plus];
		if(minus >= 1) {
			if(Math.abs(arr[minus-1]+arr[minus]) < Math.abs(ans1+ans2)) {
				ans1 = arr[minus-1]; ans2 = arr[minus];
			}
		}
		if(plus < N-1) {
			if(Math.abs(arr[plus]+arr[plus+1]) < Math.abs(ans1+ans2)) {
				ans1 = arr[plus]; ans2 = arr[plus+1];
			}
		}
		
		while(plus < N && minus >= 0) {
			if(Math.abs(arr[plus]+arr[minus]) < Math.abs(ans1+ans2)) {
				ans1 = arr[minus]; ans2 = arr[plus];
			}
			if(arr[plus]+arr[minus] > 0) minus--;
			else if(arr[plus]+arr[minus] < 0) plus++;
			else break;
		}
		
		System.out.println(ans1+" "+ans2);
	}
}
