import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		
		int n = sc.nextInt();
		int cnt = 0;
		
		for (int i = 0 ; i < n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for (int r = a ; r < a+10 ; r++) {
				for (int c = b ; c < b+10 ; c++) {
					arr[r][c] = 1;
				}
			}
		}
		
		for (int r = 0 ; r < 100 ; r++) {
			for (int c = 0 ; c < 100 ; c++) {
				cnt += arr[r][c];
			}
		}
		System.out.println(cnt);
	}
}
