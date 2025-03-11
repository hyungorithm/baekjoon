import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][][] origin = new boolean[5][5][5];
    static boolean[][][] pan = new boolean[5][5][5];
    static int[] select = new int[5];
    static boolean[] visit = new boolean[5];

    static Queue<Integer> que = new LinkedList<>();
    static boolean[][][] check;

    static int[] di = {-1,1,0,0,0,0};
    static int[] dr = {0,0,-1,1,0,0};
    static int[] dc = {0,0,0,0,-1,1};

    static int min = 99999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0 ; i < 5 ; i++){
            for(int r = 0 ; r < 5 ; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < 5 ; c++){
                    origin[i][r][c] = st.nextToken().equals("1");
                }
            }
        }

//        for(int i = 0 ; i < 5 ; i++) {
//            for (int r = 0; r < 5; r++) {
//                for (int c = 0; c < 5; c++) {
//                    System.out.print(origin[i][r][c]?1:0);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//        System.out.println("----");

        DFS(0);
        if(min == 99999999) min = -1;
        System.out.println(min);
    }

    public static void DFS(int depth){
        if(depth == 5){
            for(int i = 0 ; i < 5 ; i++){
                for(int r = 0 ; r < 5 ; r++){
                    for(int c = 0 ; c < 5 ; c++){
                        pan[i][r][c] = origin[select[i]][r][c];
                    }
                }
            }
            for(int i1 = 0 ; i1 < 4 ; i1++){
                for(int i2 = 0 ; i2 < 4 ; i2++){
                    for(int i3 = 0 ; i3 < 4 ; i3++){
                        for(int i4 = 0 ; i4 < 4 ; i4++){
                            for(int i5 = 0 ; i5 < 4 ; i5++){
//                                for(int i = 0 ; i < 5 ; i++) {
//                                    for (int r = 0; r < 5; r++) {
//                                        for (int c = 0; c < 5; c++) {
//                                            System.out.print(pan[i][r][c]?1:0);
//                                        }
//                                        System.out.println();
//                                    }
//                                    System.out.println();
//                                }
//                                System.out.println("----");
                                if(pan[0][0][0]) {
                                    que.clear();
                                    que.add(0);
                                    que.add(0);
                                    que.add(0);
                                    check = new boolean[5][5][5];
                                    check[0][0][0] = true;
                                    BFS();
                                }
                                rotate(0);
                            }
                            rotate(1);
                        }
                        rotate(2);
                    }
                    rotate(3);
                }
                rotate(4);
            }
        }

        for(int i = 0 ; i < 5 ; i++){
            if(!visit[i]){
                select[depth] = i;
                visit[i] = true;
                DFS(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void BFS() {
        int cnt = 0;
        while(!que.isEmpty()){
            cnt++;
            int size = que.size()/3;
            for(int s = 0 ; s < size ; s++){
                int i = que.poll();
                int r = que.poll();
                int c = que.poll();
//                System.out.println(cnt+" "+i+" "+r+" "+c);
                for(int d = 0 ; d < 6 ; d++){
                    if(i+di[d] < 5 && i+di[d] >= 0 && r+dr[d] < 5 && r+dr[d] >= 0 && c+dc[d] < 5 && c+dc[d] >= 0 &&
                            !check[i+di[d]][r+dr[d]][c+dc[d]] && pan[i+di[d]][r+dr[d]][c+dc[d]]){
                        if(i+di[d] == 4 && r+dr[d] == 4 && c+dc[d] == 4){
//                            System.out.println("여기");
//                            System.out.println(cnt+" "+i+" "+r+" "+c);
                            if(cnt < min) min = cnt;
                            return;
                        }
                        que.add(i+di[d]); que.add(r+dr[d]); que.add(c+dc[d]);
                        check[i+di[d]][r+dr[d]][c+dc[d]] = true;
                    }
                }
            }
        }
    }

    private static void rotate(int i) {
        boolean tmp;
        tmp = pan[i][0][0]; pan[i][0][0] = pan[i][0][4]; pan[i][0][4] = pan[i][4][4]; pan[i][4][4] = pan[i][4][0]; pan[i][4][0] = tmp;
        tmp = pan[i][1][0]; pan[i][1][0] = pan[i][0][3]; pan[i][0][3] = pan[i][3][4]; pan[i][3][4] = pan[i][4][1]; pan[i][4][1] = tmp;
        tmp = pan[i][2][0]; pan[i][2][0] = pan[i][0][2]; pan[i][0][2] = pan[i][2][4]; pan[i][2][4] = pan[i][4][2]; pan[i][4][2] = tmp;
        tmp = pan[i][0][1]; pan[i][0][1] = pan[i][1][4]; pan[i][1][4] = pan[i][4][3]; pan[i][4][3] = pan[i][3][0]; pan[i][3][0] = tmp;
        tmp = pan[i][1][1]; pan[i][1][1] = pan[i][1][3]; pan[i][1][3] = pan[i][3][3]; pan[i][3][3] = pan[i][3][1]; pan[i][3][1] = tmp;
        tmp = pan[i][2][1]; pan[i][2][1] = pan[i][1][2]; pan[i][1][2] = pan[i][2][3]; pan[i][2][3] = pan[i][3][2]; pan[i][3][2] = tmp;
    }


}