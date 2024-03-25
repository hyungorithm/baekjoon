import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][][][] arr = new int[N+1][12][12][12]; // 여태 쓴 수 중 가장 큰값 + 여태 쓴 수 중 가장 작은값 + 가장 최근에 쓴 값
		
		for(int i = 2 ; i <= 10 ; i++) {			
			arr[1][i][i][i] = 1;
		}
		
		for(int i = 2 ; i <= N ; i++) {
			for(int j = 2 ; j <= 10 ; j++) {
				for(int k = 1 ; k < j ; k++) {
					for(int l = k ; l <= j ; l++) {
						arr[i][j][k][l] = (arr[i-1][j][k][l-1] + arr[i-1][j][k][l+1])%1000000000;
						if(j==l) {
							arr[i][j][k][l] = (arr[i][j][k][l] + arr[i-1][j-1][k][l-1])%1000000000;
						}
						if(k==l) {
							arr[i][j][k][l] = (arr[i][j][k][l] + arr[i-1][j][k+1][l+1])%1000000000;
						}
					}
				}
			}
		}
		int sum = 0;
		for(int i = 1 ; i <= 10 ; i++) {
			sum = (sum + arr[N][10][1][i])%1000000000;
		}
		System.out.println(sum);
	}
}
