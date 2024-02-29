import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,K,L;
	static int[] apple;
	static Deque<Integer> que = new LinkedList<>();
	
	static int[] drc = {1,1000,-1,-1000};
	static int d = 0;
	static int time = 0;
	static int[] dir;
	static int I = 0;
	
	static boolean end = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		apple = new int[K];
		Arrays.fill(apple, -1);
		
		StringTokenizer st;
		for(int i = 0 ; i < K ; i++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken()) -1;
			apple[i] = 1000*r + c;
		}
		
		L = Integer.parseInt(br.readLine());
		dir = new int[L*2+1];
		
		for(int i = 0 ; i < L ; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			dir[i*2] = X;
			if(C=='D') {
				dir[i*2+1] = 1;
			}
			else {
				dir[i*2+1] = -1;
			}
		}
		
		que.addFirst(0);
		snakeMove();
		System.out.println(time);
		
	}
	
	public static void snakeMove() {
		while(!end) {
			time++;
			snakeGo();
			if(dir[I] == time) {
				d = (d+dir[I+1]+4) %4;
				I += 2;
			}
		}
	}
	
	public static void snakeGo() {
		int head = que.getFirst() + drc[d];
		
		if(head < 0 || head/1000 >= N || head%1000 == 999 || head%1000 == N || que.contains(head)) {
			end = true;
			return;
		}
		
		que.addFirst(head);
		
		for(int i = 0 ; i < K ; i++) {
			if(head == apple[i]) {
				apple[i] = -1;
				return;
			}
		}
		que.pollLast();
	}
}
