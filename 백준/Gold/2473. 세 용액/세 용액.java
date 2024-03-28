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
		boolean[] select = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int zero = Arrays.binarySearch(arr, 0);
		if(zero < 0) zero = -zero - 1;
		
		int[] min = new int[3];
		if(zero+2 < N) {
			min[0] = zero; min[1] = zero+1; min[2] = zero+2;
		}
		if(zero > 2) {
			if(-(arr[zero-1] + arr[zero-2] + arr[zero-3]) < Math.abs(arr[min[0]] + arr[min[1]] + arr[min[2]])) {
				min[0] = zero-1; min[1] = zero-2; min[2] = zero-3;
			}
		}
		
		int key;
		int idxP;
		int idxM;
		for(int k = 0 ; k < N ; k++) {
			key = arr[k];
			idxP = zero;
			idxM = zero-1;
			select[k] = true;
			while(idxM >= 0 && idxP < N) {
				if(arr[idxM]+arr[idxP]+key > 0) {
					if(arr[idxM]+arr[idxP]+key < Math.abs(arr[min[0]]+arr[min[1]]+arr[min[2]]) && !select[idxM] && !select[idxP]) {
						min[0] = idxM; min[1] = idxP; min[2] = k;
					}
					idxM--;
				}
				else {
					if(-(arr[idxM]+arr[idxP]+key) < Math.abs(arr[min[0]]+arr[min[1]]+arr[min[2]]) && !select[idxM] && !select[idxP]) {
						min[0] = idxM; min[1] = idxP; min[2] = k;
					}
					idxP++;
				}
			}
			select[k] = false;
		}
		Arrays.sort(min);
		System.out.println(arr[min[0]]+" "+arr[min[1]]+" "+arr[min[2]]);
	}
}
