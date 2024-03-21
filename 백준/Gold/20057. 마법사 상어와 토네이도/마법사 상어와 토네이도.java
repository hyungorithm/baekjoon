import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	static int size = 1;
	static int d = 0;
	
	static int N, R, C;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+4][N+4];
		
		R = N/2 +2;
		C = N/2 +2;
		
		int sum = 0;
		for(int r = 2 ; r < N+2 ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 2 ; c < N+2 ; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				sum += arr[r][c];
			}			
		}
		
		loop:
		while(size <= N) {
			for(int i = 0 ; i < size ; i++) {
				wind();
				if(R==2 && C==2) break loop;
			}
			d = (d+1)%4;
			for(int i = 0 ; i < size ; i++) {
				wind();
			}
			d = (d+1)%4;
			size++;
			for(int i = 0 ; i < size ; i++) {
				wind();
			}
			d = (d+1)%4;
			for(int i = 0 ; i < size ; i++) {
				wind();
			}
			d = (d+1)%4;
			size++;
		}
		
		for(int r = 2 ; r < N+2 ; r++) {
			for(int c = 2 ; c < N+2 ; c++) {
				sum -= arr[r][c];
			}			
		}
		System.out.println(sum);
	}
	
	public static void wind() {
		int sand = arr[R+dr[d]][C+dc[d]];
		
		arr[R+dr[d]*3][C+dc[d]*3] += (int) ((int) sand*0.05);
		arr[R+dr[d]*2+dr[(d+1)%4]][C+dc[d]*2+dc[(d+1)%4]] += (int) ((int) sand*0.1);
		arr[R+dr[d]*2+dr[(d+3)%4]][C+dc[d]*2+dc[(d+3)%4]] += (int) ((int) sand*0.1);
		arr[R+dr[d]+dr[(d+1)%4]][C+dc[d]+dc[(d+1)%4]] += (int) ((int) sand*0.07);
		arr[R+dr[d]+dr[(d+3)%4]][C+dc[d]+dc[(d+3)%4]] += (int) ((int) sand*0.07);
		arr[R+dr[d]+dr[(d+1)%4]*2][C+dc[d]+dc[(d+1)%4]*2] += (int) ((int) sand*0.02);
		arr[R+dr[d]+dr[(d+3)%4]*2][C+dc[d]+dc[(d+3)%4]*2] += (int) ((int) sand*0.02);
		arr[R+dr[(d+1)%4]][C+dc[(d+1)%4]] += (int) ((int) sand*0.01);
		arr[R+dr[(d+3)%4]][C+dc[(d+3)%4]] += (int) ((int) sand*0.01);
		
		arr[R+dr[d]*2][C+dc[d]*2] += sand - ((int) ((int) sand*0.05) + 2*(int) ((int) sand*0.1) + 2*(int) ((int) sand*0.07) + 2*(int) ((int) sand*0.02) + 2*(int) ((int) sand*0.01));
		arr[R+dr[d]][C+dc[d]] = 0;
		
		R = R+dr[d];
		C = C+dc[d];
	}
}
