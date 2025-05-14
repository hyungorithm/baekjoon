import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] F = new int[1000001];
        int[] arr = new int[N];
        int[] ans = new int[N];

        Arrays.fill(ans, -1);

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            F[arr[i]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0 ; i < N ; i++){
            if(deque.isEmpty() || deque.peekFirst() >= F[arr[i]]){
            }
            else{
                while(!deque.isEmpty() && deque.peekFirst() < F[arr[i]]){
                    deque.removeFirst();
                    ans[deque.removeFirst()] = arr[i];
                }
            }
            deque.addFirst(i);
            deque.addFirst(F[arr[i]]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            sb.append(ans[i]+" ");
        }
        System.out.print(sb);
    }
}