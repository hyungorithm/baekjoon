import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C;
    static int row, col;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        row = (int) Math.pow(2, N-1);
        col = (int) Math.pow(2, N-1);
        
        z();
        System.out.println(ans);
    }
    
    public static void z() {
        if(N==0) {
        	return;
        }
        
        if(row <= R) {
            if(col <= C) {
                ans += 3*(Math.pow(2, N-1)*Math.pow(2, N-1));
                col += Math.pow(2, N-2);
                row += Math.pow(2, N-2);
            }
            else {
                ans += 2*(Math.pow(2, N-1)*Math.pow(2, N-1));
                col -= Math.pow(2, N-2);
                row += Math.pow(2, N-2);
            }
        }
        else {
            if(col <= C) {
                ans += 1*(Math.pow(2, N-1)*Math.pow(2, N-1));
                col += Math.pow(2, N-2);
                row -= Math.pow(2, N-2);
            }
            else {
            	col -= Math.pow(2, N-2);
                row -= Math.pow(2, N-2);
            }
        }
        N--;
        z();
    }
}