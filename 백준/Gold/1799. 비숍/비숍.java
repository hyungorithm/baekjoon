import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N, idx;
	static ArrayList<Integer>[] newArr;
	
	static int max = 0;
	static int[] visit;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        newArr = new ArrayList[N*2-1];
        
        visit = new int[N*2-1];
        Arrays.fill(visit, -1);
        
        for(int i = 0 ; i < N*2-1 ; i++) {
        	newArr[i] = new ArrayList<>();
        }
        
        for(int r = 0 ; r < N ; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c = 0 ; c < N ; c++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		if(tmp == 1) {
        			newArr[r+c].add(r-c);
        		}
        	}
        }
        
        btr(0,0);
        
        System.out.println(max);
    }
    
    public static void btr(int depth, int R) {
    	if(depth > max) {
    		max = depth;
    	}
    	
    	if(N*2-1 - R <= max - depth) return;
    	
    	for(int r = R ; r < N*2-1 ; r++) {
    		col:
    		for(int c : newArr[r]) {
    			for(int i = 0 ; i < depth ; i++) {
    				if(visit[i] == c) continue col;
    			}
    			visit[depth] = c;
    			btr(depth+1, r+1);
    		}
    	}
    }
}