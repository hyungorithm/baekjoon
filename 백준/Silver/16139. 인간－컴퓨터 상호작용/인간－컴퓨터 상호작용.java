import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int len = str.length();
		int[][] abc = new int[len][26];
		
		for(int i = 0 ; i < len ; i++) {
			if(i == 0)
				abc[i][str.charAt(i) - 'a']++ ;
			else {
				abc[i] = abc[i-1].clone();
				abc[i][str.charAt(i) - 'a']++ ;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 'a';
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			if(a1 == 0) {
				bw.write(abc[a2][a]+"\n");
			}
			else {
				bw.write((abc[a2][a] - abc[a1-1][a])+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}