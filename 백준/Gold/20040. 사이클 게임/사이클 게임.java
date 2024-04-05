import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		for(int i = 0 ; i < N ; i++) {
			p[i] = i;
		}
		
		int a,b,fa,fb;
		
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			fa = findSet(a);
			fb = findSet(b);
			
			if(fa==fb) {
				System.out.println(i);
				return;
			}
			
			else if(fa > fb)
				p[fa] = fb;
			else
				p[fb] = fa;
		}
		System.out.println(0);
	}
	
	static int findSet(int i) {
		if(i == p[i]) return i;
		return findSet(p[i]);
	}
}
