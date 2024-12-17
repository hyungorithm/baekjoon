import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String key = br.readLine();
		Stack<Integer> cnt = new Stack<>();
		StringBuilder ans = new StringBuilder();
		
		int slen = str.length();
		int klen = key.length();
		
		for(int i = 0 ; i < slen ; i++) {
			char c = str.charAt(i);
			ans.append(c);
			
			if(c == key.charAt(0)) {
				cnt.add(1);
			}
			else if(!cnt.isEmpty() && c == key.charAt(cnt.peek())) {
				cnt.add(cnt.pop() + 1);
			}
			else {
				cnt.clear();
			}
			
			if(!cnt.isEmpty() && cnt.peek() == klen) {
				ans.delete(ans.length() - klen, ans.length());
				cnt.pop();
			}
		}
		if(ans.isEmpty()) {
			ans.append("FRULA");
		}
		System.out.println(ans);
		
	}
}