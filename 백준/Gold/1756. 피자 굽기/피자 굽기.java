import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arrD = new int[D];
        int[] arrN = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < D ; i++){
            arrD[i] = Integer.parseInt(st.nextToken());
            if(i != 0 && arrD[i-1] < arrD[i]){
                arrD[i] = arrD[i-1];
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int pointer = D-1;
        int I = 0;
        int tmpMax = 0;

        while(I < N){
            if(pointer < 0){
                pointer--;
                break;
            }
            if(arrN[I] <= tmpMax){
                pointer--;
                I++;
            }
            else{
                if(arrN[I] > arrD[pointer]){
                    pointer--;
                    continue;
                }
                tmpMax = arrN[I];
                pointer--;
                I++;
            }
        }

        System.out.println(pointer+2);
    }
}