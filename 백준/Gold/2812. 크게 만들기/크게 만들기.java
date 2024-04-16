import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		String str = br.readLine();
		for(int i = N-1 ; i >= 0 ; i--) {
			stack.add(str.charAt(i)-'0');
		}
		
		Deque<Integer> que = new LinkedList<>();
		
		int cnt = 0;
		while(cnt < K && !stack.isEmpty()) {
			if(que.isEmpty()) que.add(stack.pop());
			
			if(que.peekLast() < stack.peek()) {
				que.pollLast();
				cnt++;
				continue;
			}
			else que.add(stack.pop());
		}
		
		while(!stack.isEmpty()) {
			que.add(stack.pop());
		}
		
		for(int i = 0 ; i < N-K ; i++) {
			System.out.print(que.poll());
		}
		
	}
}
