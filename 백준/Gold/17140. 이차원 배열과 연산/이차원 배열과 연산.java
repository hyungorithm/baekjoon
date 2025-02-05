import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int maxR = 3;
        int maxC = 3;

        int[][] arr = new int[100][100];
        for(int r = 0 ; r < 3 ; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < 3 ; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for(int I = 0 ; I <= 100 ; I++){

            if(arr[R-1][C-1] == K){
                System.out.println(I);
                return;
            }


            if(maxR >= maxC){
                int max = 0;

                for(int r = 0 ; r < maxR ; r++){
                    int[][] tmp = new int[100][2];
                    for(int i = 0 ; i < 100 ; i++){
                        tmp[i][0] = i+1;
                    }
                    for(int c = 0 ; c < maxC ; c++){
                        if(arr[r][c] == 0) continue;
                        tmp[arr[r][c]-1][1] ++;
                    }
                    Arrays.sort(tmp, (o1, o2) ->{
                        if (o1[1] == 0 && o2[1] == 0) return 0;
                        else if(o1[1] == 0) return 1;
                        else if(o2[1] == 0) return -1;
                        else return o1[1]-o2[1];
                    });

                    int tmpMax = 0;
                    for(int i = 0 ; i < 50 ; i++){
                        if(tmp[i][1] == 0){
                            arr[r][i*2] = 0;
                            arr[r][i*2+1] = 0;
                        }
                        else{
                            arr[r][i*2] = tmp[i][0];
                            arr[r][i*2+1] = tmp[i][1];
                            tmpMax += 2;
                        }
                    }
                    if(tmpMax > max) max = tmpMax;
                }
                maxC = max;
            }

            else{
                int max = 0;

                for(int c = 0 ; c < maxC ; c++){
                    int[][] tmp = new int[100][2];
                    for(int i = 0 ; i < 100 ; i++){
                        tmp[i][0] = i+1;
                    }
                    for(int r = 0 ; r < maxR ; r++){
                        if(arr[r][c] == 0) continue;
                        tmp[arr[r][c]-1][1] ++;
                    }
                    Arrays.sort(tmp, (o1, o2) ->{
                        if (o1[1] == 0 && o2[1] == 0) return 0;
                        if(o1[1] == 0) return 1;
                        else if(o2[1] == 0) return -1;
                        else return o1[1]-o2[1];
                    });

                    int tmpMax = 0;
                    for(int i = 0 ; i < 50 ; i++){
                        if(tmp[i][1] == 0){
                            arr[i*2][c] = 0;
                            arr[i*2+1][c] = 0;
                        }
                        else{
                            arr[i*2][c] = tmp[i][0];
                            arr[i*2+1][c] = tmp[i][1];
                            tmpMax += 2;
                        }
                    }
                    if(tmpMax > max) max = tmpMax;
                }
                maxR = max;
            }
        }

        System.out.println(-1);
    }
}