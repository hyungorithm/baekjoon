import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		Queue<Integer> list = new LinkedList<>();
		
		int id = 0;
		int max = 0;
		if(str.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		for(int i = 0 ; i < len ; i++) {
			if(str.charAt(i) == '0') {
				System.out.println(0);
				return;				
			}

			if(i+1 < len && str.charAt(i+1) == '0') {
				if(str.charAt(i) > '2') {					
					System.out.println(0);
					return;				
				}
				id--;
				if(id > 0) list.add(id);
				if(id > max) max = id;
				id = 0;
				i++;
				continue;
			}
			
			if(i+1 < len && str.charAt(i+1) >= '1' && (str.charAt(i) == '1' || (str.charAt(i) == '2' && str.charAt(i+1) <= '6'))) {
				id++;
			}
			else {
				if(id > 0) list.add(id);
				if(id > max) max = id;
				id = 0;
			}
		}
		if(id > 0) list.add(id);
		if(id > max) max = id;
		
		long ans = 1L;
		
		int[] fibo = new int[max+1];
		if(max >= 1) fibo[1] = 2;
		if(max >= 2) fibo[2] = 3;
		for(int i = 3 ; i <= max ; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2]) % 1000000;
		}
//		System.out.println(list);
//		System.out.println(Arrays.toString(fibo));
		
		while(!list.isEmpty()) {
			ans *= fibo[list.poll()];
		}
		System.out.println(ans%1000000);
	}
}
