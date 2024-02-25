import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static Stack<Character> operator = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String postfix = "";
		
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(c == '(') {
				operator.add('(');
			}
			else if(c == ')') {
				while(operator.peek() != '(') {
					postfix += operator.pop();
				}
				operator.pop();
			}
			else if(c == '*') {
				while(!operator.isEmpty() && operator.peek() != '+' && operator.peek() != '-' && operator.peek() != '(') {
					postfix += operator.pop();
				}
				operator.add('*');
			}
			else if(c == '/') {
				while(!operator.isEmpty() && operator.peek() != '+' && operator.peek() != '-' && operator.peek() != '(') {
					postfix += operator.pop();
				}
				operator.add('/');
			}
			else if(c == '+') {
				while(!operator.isEmpty() && operator.peek() != '(') {
					postfix += operator.pop();
				}
				operator.add('+');
			}
			else if(c == '-') {
				while(!operator.isEmpty() && operator.peek() != '(') {
					postfix += operator.pop();
				}
				operator.add('-');
			}
			else {
				postfix += c;
			}
		}
		while(!operator.isEmpty()) {
			postfix += operator.pop();
		}
		
		System.out.println(postfix);
	}
	
}
