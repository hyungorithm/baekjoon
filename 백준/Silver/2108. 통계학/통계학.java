import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] numArr = new int[8002];
		int[] sorted = new int[n];
		
		double sum = 0.0;
		
		for(int ni = 0 ; ni < n ; ni++) {
			int num = Integer.parseInt(br.readLine());
			arr[ni] = num;
			sum += num;
			numArr[num+4000]++;
		}
		
		boolean second = false;
		int maxIdx = 8001;
		for (int i = 0 ; i <= 8000 ; i++) {
			if(numArr[i] > numArr[maxIdx]) {
				maxIdx = i;
				second = false;
			}
			
			else if(numArr[i] == numArr[maxIdx] && !(second)) {
				maxIdx = i;
				second = true;
			}
		}
		int choibeen = maxIdx - 4000;
		
		
		for (int i = 1 ; i < 8001 ; i++) {
			numArr[i] += numArr[i - 1];
		}
		
		for (int i = n - 1 ; i >= 0 ; i--) {
			sorted[--numArr[arr[i] + 4000]] = arr[i];
		}
		
		System.out.println(Math.round(sum/n));
		System.out.println(sorted[(n-1)/2]);
		System.out.println(choibeen);
		System.out.println(sorted[n-1]-sorted[0]);
		
		
		
	}
}
