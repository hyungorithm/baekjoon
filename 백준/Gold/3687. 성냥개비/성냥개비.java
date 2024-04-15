import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int ti = 0 ; ti < T ; ti++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==2) System.out.print(1);
			else if(N==3) System.out.print(7);
			else if(N==4) System.out.print(4);
			else if(N==5) System.out.print(2);
			else if(N==6) System.out.print(6);
			else if(N==10) System.out.print(22);
			else if(N%7==3) {
				System.out.print(200);
				for(int i = 0 ; i < N/7-2 ; i++) {
					System.out.print(8);
				}
			}
			else {
				if(N%7==0) System.out.print(8);
				else if(N%7==1) System.out.print(10);
				else if(N%7==2) System.out.print(18);
				else if(N%7==4) System.out.print(20);
				else if(N%7==5) System.out.print(28);
				else if(N%7==6) System.out.print(68);
				
				for(int i = 0 ; i < N/7-1 ; i++) {
					System.out.print(8);
				}
			}
			
			
			System.out.print(" ");
			
			if(N%2==1) System.out.print(7);
			else System.out.print(1);
			for(int i = 0 ; i < N/2-1 ; i++) {
				System.out.print(1);
			}
			
			System.out.println();
		}
		
		
		
	}
}
