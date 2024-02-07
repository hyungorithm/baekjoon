import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String in = "";
		while((in = br.readLine()) != null) {
			int n = Integer.parseInt(in);
			System.out.println(cant(n));
		}

	}
	
	public static String cant(int depth) throws IOException {
		String str = "";
		
		if(depth == 0) {
			str = "-";
			return str;
		}
		
		str += cant(depth-1);
		str += cant(depth-1).replace("-", " ");
		str += cant(depth-1);
		
		return str;
		
	}
}
