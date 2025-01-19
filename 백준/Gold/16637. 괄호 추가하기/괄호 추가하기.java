import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] sel;
    static int[] add;

    static int max = -Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        arr = new int[N];
        sel = new boolean[N];
        add = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = str.charAt(i) -'0'; // +: -5, -: -3, *: -6
        }

        for(int i = 0 ; i < N ; i++){
            if(arr[i] > 0) continue;
            else if(arr[i] == -5){
                add[i] = arr[i-1] + arr[i+1];
            }
            else if(arr[i] == -3){
                add[i] = arr[i-1] - arr[i+1];
            }
            else if(arr[i] == -6){
                add[i] = arr[i-1] * arr[i+1];
            }
        }

        SELECT(1);
        System.out.println(max);
    }

    private static void SELECT(int index) {
        int now = arr[0];
        for(int i = 1 ; i < N ; i+=2){
            if(sel[i]) {
                now = add[i];
                continue;
            }
            if(sel[i+1]) {
                if(arr[i] == -5){
                    now += add[i+2];
                }
                else if(arr[i] == -3){
                    now -= add[i+2];
                }
                else if(arr[i] == -6){
                    now *= add[i+2];
                }
                i += 2;
            }
            else{
                if(arr[i] == -5){
                    now += arr[i+1];
                }
                else if(arr[i] == -3){
                    now -= arr[i+1];
                }
                else if(arr[i] == -6){
                    now *= arr[i+1];
                }
            }
        }
        if(now > max) max = now;

        for(int i = index ; i < N ; i+=2){
            sel[i-1] = true;
            sel[i] = true;
            sel[i+1] = true;
            SELECT(i+4);
            sel[i-1] = false;
            sel[i] = false;
            sel[i+1] = false;
        }
    }
}