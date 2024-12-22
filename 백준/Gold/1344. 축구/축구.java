import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] prime = {0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0};
		double[] a18 = new double[19];
		double[] b18 = new double[19];
		
		double A = Integer.parseInt(br.readLine())/100.0;
		double B = Integer.parseInt(br.readLine())/100.0;
		
		double A18 = A * A * A;
		A18 = A18 * A18 * A18;
		A18 = A18 * A18;
		
		double B18 = B * B * B;
		B18 = B18 * B18 * B18;
		B18 = B18 * B18;
		
		int up = 18;
		int down = 1;
		a18[18] = A18;
		b18[18] = B18;
		
		for(int i = 17 ; i >= 0 ; i--) {
			a18[i] = a18[i+1] * up * (1 - A) / down / A;
			b18[i] = b18[i+1] * up * (1 - B) / down / B;
			up--;
			down++;
		}
		
		
		double AA = 0.0;
		double BB = 0.0;
		for(int i = 0 ; i < 19 ; i++) {
			AA += prime[i] * a18[i];
			BB += prime[i] * b18[i];
		}
		
		if(A == 0) AA = 0;
		if(B == 0) BB = 0;
		
		double ans = 1- (1-AA)*(1-BB);
		
		System.out.println(ans);
	}
}