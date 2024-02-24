import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sw = Integer.parseInt(br.readLine());
		int[] arr = new int[sw];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < sw ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int pp = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < pp ; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gen == 1) {
				for(int j = num ; j <= sw ; j += num) {
					arr[j-1] = 1 - arr[j-1];
				}
			}
			else {
				int c = 0;
				while(num - 1 + c < sw && num - 1 - c >= 0) {
					if(c==0) {
						arr[num-1] = 1 - arr[num-1];
					}
					else {
						if(arr[num-1-c] == arr[num-1+c]) {
							arr[num-1-c] = 1 - arr[num-1-c];
							arr[num-1+c] = 1 - arr[num-1+c];
						}
						else {
							break;
						}
					}
					c++;
				}
			}
		}
		
		for(int i = 0 ; i < sw ; i++) {
			System.out.print(arr[i]+" ");
			if(i%20 == 19) {
				System.out.println();
			}
		}
		
	}
}