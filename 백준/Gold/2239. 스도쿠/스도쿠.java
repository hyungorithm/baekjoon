import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Integer> dot = new ArrayList<>();
	public static int n = 0;
	public static int[][] arr = new int[9][9];
	public static boolean fin = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int r = 0 ; r < 9 ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < 9 ; c++) {
				arr[r][c] = str.charAt(c) - '0';
				if(arr[r][c] == 0) {
					dot.add(r); dot.add(c);
					n++;
				}
			}
		}
		
		doku(0);
	}
	
	public static void doku(int depth) {
		if(depth == n) {
			fin = true;
			for(int r = 0 ; r < 9 ; r++) {
				for(int c = 0 ; c < 9 ; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
			return;
		}
		
		int r = dot.get(depth*2);
		int c = dot.get(depth*2 + 1);
		
		numbers:
			for(int num = 1 ; num <= 9 ; num++) {
				for(int garo = 0 ; garo < 9 ; garo++) {
					if(num == arr[r][garo]) {
						continue numbers;
					}
				}
				for(int sero = 0 ; sero < 9 ; sero++) {
					if(num == arr[sero][c]) {
						continue numbers;
					}
				}
				for(int boxr = (r/3)*3 ; boxr < (r/3)*3 + 3 ; boxr++) {
					for(int boxc = (c/3)*3 ; boxc < (c/3)*3 + 3 ; boxc++) {
						if(num == arr[boxr][boxc]) {
							continue numbers;
						}
					}
				}
				
				arr[r][c] = num;
				
				doku(depth + 1);
				
				arr[r][c] = 0;
				
				if(fin)
					return;
			}
	}
}
