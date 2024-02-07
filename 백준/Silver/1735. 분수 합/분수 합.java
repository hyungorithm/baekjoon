import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		
		int na = a1*b2 + a2*b1;
		int nb = a2*b2;
		
		
		int a = na;
		int b = nb;
		if(na < nb) {
			a = nb;
			b = na;
		}
		
		while(a%b != 0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		
		na /= b;
		nb /= b;
		
		System.out.println(na+" "+nb);
	}
}
