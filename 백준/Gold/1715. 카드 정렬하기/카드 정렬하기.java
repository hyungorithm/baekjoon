import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int ans = 0;
		int tmp;
		while(pq.size() > 1) {
			tmp = pq.poll() + pq.poll();
			ans += tmp;
			pq.add(tmp);
		}
		System.out.println(ans);
	}
}
