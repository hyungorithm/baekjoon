import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken())-1;
		int G = Integer.parseInt(st.nextToken())-1;
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		if(S==G) {
			System.out.println(0);
			return;
		}
		
		boolean[] visit = new boolean[F];
		que.add(S);
		visit[S] = true;
		
		int cnt = 0;
		while(!que.isEmpty()) {
			cnt++;
			int size = que.size();
			for(int i = 0 ; i < size ; i++) {
				int now = que.poll();
				if(now + U == G || now - D == G) {
					System.out.println(cnt);
					return;
				}
				if(now + U >= 0 && now + U < F && !visit[now+U]) {
					que.add(now + U);
					visit[now+U] = true;
				}
				if(now - D >= 0 && now - D < F && !visit[now-D]) {
					que.add(now - D);
					visit[now-D] = true;
				}
			}
		}
		System.out.println("use the stairs");
	}
}