import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		int cur = 0;
		int time = 0;
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			int tk = Integer.parseInt(st2.nextToken());
			while(true) {
				time++;
				if(q.size() >= w) {
					cur -= q.poll();
				}
				if(cur+tk <= L) {
					q.add(tk);
					cur += tk;
					break;
				}
				else
					q.add(0);
			}
		}
		System.out.println(time+w);
	}
}
