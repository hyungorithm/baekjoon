import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] loop;
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) + 1;
        arr = new int[N];
        loop = new boolean[N];
        road = new int[N];

        for(int i = 1 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1 ; i < N ; i++){
            if(loop[i]) continue;
            Arrays.fill(road, 0);
            DFS(i, 0);
        }

        int cnt = 0;
        for(int i = 1 ; i < N ; i++){
            if(loop[i]) cnt++;
        }

        System.out.println(cnt);

        for(int i = 1 ; i < N ; i++){
            if(loop[i]) System.out.println(i);
        }
    }

    private static void DFS(int num, int index) {
        if(loop[num]) return;
        road[index] = num;
        for(int i = 0 ; i < index ; i++){
            if(road[i] == num){
                for(int j = i ; j < index ; j++){
                    loop[road[j]] = true;
                }
            }
        }
        DFS(arr[num], index+1);
    }
}