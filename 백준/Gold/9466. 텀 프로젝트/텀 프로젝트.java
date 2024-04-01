import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int start;
	static int[] pair;
	static byte[] team;
	static ArrayList<Integer> set = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int ti = 0 ; ti < T ; ti++) {
        	n = Integer.parseInt(br.readLine());
        	pair = new int[n+1];
        	team = new byte[n+1];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 1 ; i <= n ; i++) {
        		pair[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	loop:
        	for(int i = 1 ; i <= n ; i++) {
        		if(team[i] > 0) continue;
        		start = i;
        		set.clear();
        		set.add(i);
        		
        		int tmp = pair[i];
        		for(int t = 0 ; t < n ; t++) {
        			if(team[tmp] > 0) {
        				for(int e : set) {
        					team[e] = 1;
        				}
        				continue loop;
        			}
        			if(tmp == start) {
        				for(int e : set) {
        					team[e] = 2;
        				}
        				continue loop;
        			}
        			set.add(tmp);
        			set.add(tmp);
        			tmp = pair[tmp];
        		}
        		
        		if(team[tmp] > 0) continue;
        		start = tmp;
        		set.clear();
        		set.add(tmp);
        		
        		tmp = pair[tmp];
        		for(int t = 0 ; t < n ; t++) {
        			if(team[tmp] > 0) {
        				for(int e : set) {
        					team[e] = 1;
        				}
        				continue loop;
        			}
        			if(tmp == start) {
        				for(int e : set) {
        					team[e] = 2;
        				}
        				continue loop;
        			}
        			set.add(tmp);
        			tmp = pair[tmp];
        		}
        		
        	}
        	
        	int cnt = 0;
        	for(int i = 1 ; i <= n ; i++) {
        		if(team[i] <= 1) cnt++;
        	}
        	System.out.println(cnt);
        }
    }
}