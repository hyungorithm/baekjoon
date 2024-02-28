import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, t, x, y, score;
	static int I;
	static int[][] arr = new int[10][10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(I = 1 ; I <= N ; I++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(t==1)
				block1(I,x,y,0);
			else if(t==2)
				block2(I,x,y,true);
			else
				block3(I,x,y,true);
			
			scoreCheck();
			blockRemove();
			
//			for(int r = 0 ; r < 10 ; r++) {
//				for(int c = 0 ; c < 10 ; c++) {
//					System.out.print(arr[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(score);
//			System.out.println();
			
		}
		System.out.println(score);
		int num = 0;
		for(int r = 0 ; r < 10 ; r++) {
			for(int c = 0 ; c < 10 ; c++) {
				if(arr[r][c] > 0) num++;
			}
		}
		System.out.println(num);
		
	}

	static void block1(int I, int r, int c, int lr) {
		if(lr == 0 || lr == 1) {
			int idx = r;
			while(idx < 10 && arr[idx][c] == 0) {
				idx++;
			}
			arr[idx-1][c] = I;
		}
		
		if(lr == 0 || lr == 2) {
			int idx = c;
			while(idx < 10 && arr[r][idx] == 0) {
				idx++;
			}
			arr[r][idx-1] = I;
		}
	}
	
	static void block2(int I, int r, int c, boolean first) {
		int idx = r;
		while(idx < 10 && arr[idx][c] == 0 && arr[idx][c+1] == 0) {
			idx++;
		}
		arr[idx-1][c] = I;
		arr[idx-1][c+1] = I;
		
		if(first) {
			idx = c;
			while(idx < 10 && arr[r][idx] == 0) {
				idx++;
			}
			arr[r][idx-1] = I;
			arr[r][idx-2] = I;
		}
	}
	
	static void block3(int I, int r, int c, boolean first) {
		int idx = c;
		while(idx < 10 && arr[r][idx] == 0 && arr[r+1][idx] == 0) {
			idx++;
		}
		arr[r][idx-1] = I;
		arr[r+1][idx-1] = I;
		
		if(first) {
			idx = r;
			while(idx < 10 && arr[idx][c] == 0) {
				idx++;
			}
			arr[idx-1][c] = I;
			arr[idx-2][c] = I;
		}
	}
	
	static void scoreCheck() {
		int scoreTmp = 0;
		for(int i = 9 ; i >= 6 ; i--) {
			if(arr[i][0] > 0 && arr[i][1] > 0 && arr[i][2] > 0 && arr[i][3] > 0) {
				arr[i][0] = 0; arr[i][1] = 0; arr[i][2] = 0; arr[i][3] = 0;
				scoreTmp++;
				blockArrLeft(i);
			}
			if(arr[0][i] > 0 && arr[1][i] > 0 && arr[2][i] > 0 && arr[3][i] > 0) {
				arr[0][i] = 0; arr[1][i] = 0; arr[2][i] = 0; arr[3][i] = 0;
				scoreTmp++;
				blockArrRight(i);
			}
		}
		
		if(scoreTmp > 0) {
			score += scoreTmp;
			scoreCheck();
		}
	}
	
	static void blockRemove() {
		blockRmvLeft();
		blockRmvRight();
	}
	
	static void blockRmvLeft() {
		if(arr[5][0] + arr[5][1] + arr[5][2] + arr[5][3] > 0) {
			for(int c = 0 ; c <= 3 ; c++) {
				for(int r = 9 ; r >= 4 ; r--) {
					arr[r][c] = arr[r-1][c];
				}
			}
			blockRmvLeft();
		}
	}
	
	static void blockRmvRight() {
		if(arr[0][5] + arr[1][5] + arr[2][5] + arr[3][5] > 0) {
			for(int r = 0 ; r <= 3 ; r++) {
				for(int c = 9 ; c >= 4 ; c--) {
					arr[r][c] = arr[r][c-1];
				}
			}
			blockRmvRight();
		}
	}
	
	static void blockArrLeft(int i) {
		for(int r = i ; r >= 4 ; r--) {
			for(int c = 0 ; c <= 3 ; c++) {
				arr[r][c] = arr[r-1][c];
			}
		}
	}
		
	static void blockArrRight(int i) {
		for(int c = i ; c >= 4 ; c--) {
			for(int r = 0 ; r <= 3 ; r++) {
				arr[r][c] = arr[r][c-1];
			}
		}
	}
}
