import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static boolean fin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        BTR(0);
    }

    private static void BTR(int depth) {
        if(fin) return;

        if(depth == N){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < N ; i++){
                sb.append(arr[i]);
            }
            System.out.println(sb);
            fin = true;
            return;
        }

        loop1:
        for(int i = 1 ; i <= 3 ; i++){
            arr[depth] = i;
            int tmp = (depth+1)/2;
            loop2:
            for(int a = 1 ; a <= tmp ; a++){
                for(int b = 0 ; b < a ; b++){
                    if(arr[depth -b] != arr[depth -a -b]){
                        continue loop2;
                    }
                }
                continue loop1;
            }
            BTR(depth+1);
        }
    }
}