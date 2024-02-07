import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[][] arr;
	public static int n;
	public static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = (int)(Math.pow(2, n)) - 1;
		arr = new int[k][2];
		
		System.out.println(k);
		hanoi(0);
		for (int i = 0 ; i < k ; i++) {
			bw.write(arr[i][0]+" "+arr[i][1]+"\n");
		}
		bw.flush();
		bw.close();

	}
	
	public static void hanoi (int depth) throws IOException {
		if(depth == n) {
			return;
		}
		
		int cnt = 1;
		
		if(depth%2 == 0) {
			for (int i = (int)(Math.pow(2, n - depth - 1)) - 1 ; i < k ; i += (int)(Math.pow(2, n - depth))) {
				arr[i][0] = cnt;
				cnt = (cnt +1)%3 + 1;
				arr[i][1] = cnt;
			}
		}
		
		else {
			for (int i = (int)(Math.pow(2, n - depth - 1)) - 1 ; i < k ; i += (int)(Math.pow(2, n - depth))) {
				arr[i][0] = cnt;
				cnt = cnt%3 + 1;
				arr[i][1] = cnt;
			}
		}
		
		hanoi(depth + 1);
		
	}
}
