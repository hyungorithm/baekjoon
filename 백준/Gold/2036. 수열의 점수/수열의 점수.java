import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        long cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(arr[i] >= 0) break;
            else if(i+1 >= n || arr[i+1] > 0){
                cnt += arr[i];
                break;
            }
            else if(arr[i+1] == 0){
                break;
            }
            else{
                cnt += arr[i] * arr[i+1];
                i++;
            }
        }

        for(int i = n-1 ; i >= 0 ; i--){
            if(arr[i] <= 0) break;
            else if(arr[i] == 1){
                cnt++;
            }
            else if(i-1 < 0 || arr[i-1] <= 1){
                cnt += arr[i];
            }
            else{
                cnt += arr[i] * arr[i-1];
                i--;
            }
        }

        System.out.println(cnt);
    }
}