import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pqmax = new PriorityQueue<>();
		PriorityQueue<Integer> pqmin = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(i==0 || pqmin.peek() > tmp) {
				pqmin.add(tmp);
				if(pqmin.size() > pqmax.size()+1) {
					pqmax.add(pqmin.poll());
				}
			}
			else {
				pqmax.add(tmp);
				if(pqmax.size() > pqmin.size()) {
					pqmin.add(pqmax.poll());
				}
			}
			sb.append(pqmin.peek()+"\n");
		}
		System.out.println(sb);
	}
}
