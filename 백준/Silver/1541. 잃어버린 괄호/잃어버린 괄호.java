import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		str += '+';
		
		int tmp = 0;
		int sum = 0;
		boolean minus = false;
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				tmp = tmp*10 + str.charAt(i) - '0';
			}
			else {
				if(!minus) {
					sum += tmp;
					tmp = 0;
					if(str.charAt(i) == '-')
						minus = true;
				}
				else {
					sum -= tmp;
					tmp = 0;
				}
			}
		}
		
		System.out.println(sum);
		
	}
}
