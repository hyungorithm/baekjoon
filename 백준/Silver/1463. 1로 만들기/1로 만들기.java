import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(minCal(N, 0));

    }

    public static int minCal(int a,int count){
        if(a < 2){ //min 계산 때문에 a가 1이 되지 않는 경우가 있어서 스택오버플로우 발생..
            return count;
        }

        else{
            return Math.min(minCal(a / 2,count + 1 + (a % 2))
                    ,minCal(a / 3, count + 1 + (a % 3)));
        }
    }
}
