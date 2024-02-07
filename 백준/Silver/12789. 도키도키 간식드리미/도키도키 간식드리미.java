import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		Stack<Integer> stack = new Stack<>();
		
		int n = sc.nextInt();
		
		int cnt = 1;
		int st = 0;
		for (int i = 0 ; i < n ; i++) {
			int stu = sc.nextInt();
			stack.push(stu);
			
			while (!stack.empty() && stack.peek() == cnt) {
				stack.pop();
				cnt++;
			}
		}
		
		if (stack.empty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}
}
