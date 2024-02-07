import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stk = new Stack<>();
		String str = br.readLine();
		int err = 0;
		for (int j = 0 ; j < str.length() ; j++) {
			if(str.charAt(j)=='(')
				stk.add(0);
			else {
				if(stk.isEmpty()) {
					err++;
				}
				else
					stk.pop();
			}
		}
		System.out.println(err+stk.size());
		
	}
}
