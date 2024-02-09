import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long[][][] w = new long[22][22][22];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		int A = 0; int B = 0 ; int C = 0;
		
		
		for(int a = 0 ; a <= 21 ; a++) {
			for(int b = 0 ; b <= 21 ; b++) {
				for(int c = 0 ; c <= 21 ; c++) {
					if(a==0 || b==0 || c==0) {
						w[a][b][c] = 1;
					}
					
					else if(a>20 || b>20 || c>20) {
						w[a][b][c] = w[20][20][20];
					}
					
					else if(a<b && b<c) {
						w[a][b][c] = w[a][b][c-1] + w[a][b-1][c-1] - w[a][b-1][c];
					}
					
					else {
						w[a][b][c] = w[a-1][b][c] + w[a-1][b-1][c] + w[a-1][b][c-1] - w[a-1][b-1][c-1];
					}
				}
			}
		}
		
		for(int a = 0 ; a <= 21 ; a++) {
			for(int b = 0 ; b <= 21 ; b++) {
				for(int c = 0 ; c <= 21 ; c++) {
					if(a==0 || b==0 || c==0) {
						w[a][b][c] = 1;
					}
					
					else if(a>20 || b>20 || c>20) {
						w[a][b][c] = w[20][20][20];
					}
					
					else if(a<b && b<c) {
						w[a][b][c] = w[a][b][c-1] + w[a][b-1][c-1] - w[a][b-1][c];
					}
					
					else {
						w[a][b][c] = w[a-1][b][c] + w[a-1][b-1][c] + w[a-1][b][c-1] - w[a-1][b-1][c-1];
					}
				}
			}
		}
		
		while(A!=-1 || B!=-1 || C!=-1) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(A==-1 && B==-1 && C==-1)
				break;
			
			System.out.println("w("+A+", "+B+", "+C+") = "+wow(A,B,C));
		}
		
	}
	
	public static long wow(int A, int B, int C) {
		if(A<=0) A = 0;
		if(B<=0) B = 0;
		if(C<=0) C = 0;
		
		if(A>20) A = 21;
		if(B>20) B = 21;
		if(C>20) C = 21;
		
		return w[A][B][C];
	}
	
}
