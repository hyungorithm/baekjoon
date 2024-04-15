import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[10];
		
		for(int n = 0 ; n < N ; n++) {
			String str = br.readLine();
			int len = str.length();
			long ten = 10;
			for(int i = len-1 ; i >= 0 ; i--) {
				arr[str.charAt(i)-'A'] += ten;
				ten *= 10;
			}
			
			if(arr[str.charAt(0)-'A'] %10 == 0)
				arr[str.charAt(0)-'A']++;
		}
		
		Arrays.sort(arr);
		for(int i = 0 ; i < 10 ; i++) {
			if(arr[i]%10==0) {
				for(int j = i ; j > 0 ; j--) {
					long tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
				break;
			}
		}
		
		long ans = 0;
		int num = 9;
		for(int i = 9 ; i >= 0 ; i--) {
			ans += num*(arr[i]/10);
			num--;
		}
		System.out.println(ans);
		
	}
}
