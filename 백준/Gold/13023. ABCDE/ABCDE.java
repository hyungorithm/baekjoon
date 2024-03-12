import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static int N, M;
	static boolean able;
	static Set<Integer> visit = new HashSet<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N];
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	arr[r].add(c);
        	arr[c].add(r);
        	
        }
        
        for(int i = 0 ; i < N ; i++) {
        	visit.add(i);
        	dfs(i, 0);
        	
        	if(able) break;
        	visit.remove(i);
        }
        
        if(able) System.out.println(1);
        else System.out.println(0);
    }
    
    public static void dfs(int num, int depth) {
    	if(depth == 4) {
    		able = true;
    		return;
    	}
    	
    	if(arr[num].isEmpty()) return;
    	
    	for(int i : arr[num]) {
    		if(!visit.contains(i)) {
    			visit.add(i);
    			dfs(i, depth+1);
    			visit.remove(i);
    			
    		}
    	}
    }
}