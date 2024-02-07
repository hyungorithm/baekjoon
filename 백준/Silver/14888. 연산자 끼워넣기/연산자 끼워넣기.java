import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[] op = new int[4];
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int ni = 0 ; ni < n ; ni++) {
			arr[ni] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 4 ; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		oper(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void oper(int num, int depth) {
		if(depth == n) {
			if(num > max)
				max = num;
			if(num < min)
				min = num;
			return;
		}
		
		if(op[0] != 0) {
			op[0]--;
			oper(num+arr[depth], depth+1);
			op[0]++;
		}
		if(op[1] != 0) {
			op[1]--;
			oper(num-arr[depth], depth+1);
			op[1]++;
		}
		if(op[2] != 0) {
			op[2]--;
			oper(num*arr[depth], depth+1);
			op[2]++;
		}
		if(op[3] != 0) {
			op[3]--;
			oper(num/arr[depth], depth+1);
			op[3]++;
		}
		
	}
	
}
