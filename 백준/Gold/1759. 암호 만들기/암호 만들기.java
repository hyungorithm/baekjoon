import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    static char[] now;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        now = new char[L];
        arr = new char[C];
        visit = new boolean[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        DFS(0,0);

        System.out.println(sb);
    }

    private static void DFS(int start, int depth) {
        if(depth == L){
            int ja = 0; int mo = 0;
            for(int i = 0 ; i < L ; i++){
                if(now[i] == 'a' || now[i] == 'e' || now[i] == 'i' || now[i] == 'o' || now[i] == 'u'){
                    mo++;
                }
                else ja++;
            }

            if(ja >= 2 && mo >= 1){
                for(int i = 0 ; i < L ; i++){
                    sb.append(now[i]);
                }
                sb.append("\n");
            }

            return;
        }

        for(int i = start ; i < C ; i++){
            now[depth] = arr[i];
            DFS(i+1, depth+1);
        }
    }
}

