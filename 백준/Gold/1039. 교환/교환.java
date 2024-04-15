import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<int[]> que = new LinkedList<>();
	static int[] arr;
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		len = str.length();
		arr = new int[len];
		
		for(int i = 0 ; i < len ; i++) {
			arr[i] = str.charAt(i)-'0';
		}
		if(len==1 || (len==2 && arr[1]==0)) {
			System.out.println(-1); return;
		}
		
		que.add(arr);
		for(int i = 0 ; i < K ; i++) {
			BFS();
		}
		
		int size = que.size();
		
		int max = 0;
		int tmp = 0;
		for(int i = 0 ; i < size ; i++) {
			int[] now = que.poll();
			int ten = 1;
			tmp = 0;
			for(int j = len-1 ; j >= 0 ; j--) {
				tmp += ten * now[j];
				ten *= 10;
			}
			if(tmp > max) max = tmp;
		}
		System.out.println(max);
	}

	private static void BFS() {
		int size = que.size();
		boolean[] visit = new boolean[10000000];
		
		for(int i = 0 ; i < size ; i++) {
			int[] now = que.poll();
			for(int r = 0 ; r < len-1 ; r++) {
				for(int c = r+1 ; c < len ; c++) {
					int[] next = Arrays.copyOf(now, len);
					int tmp = next[r];
					next[r] = next[c];
					next[c] = tmp;
					
					int ten = 1;
					tmp = 0;
					for(int j = len-1 ; j >= 0 ; j--) {
						tmp += ten * next[j];
						ten *= 10;
					}
					if(visit[tmp]) continue;
					visit[tmp] = true;
					que.add(next);
				}
			}
		}
	}
}
