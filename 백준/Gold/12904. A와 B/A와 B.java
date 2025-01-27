import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        int sLen = S.length();
        int tLen = T.length();
        boolean isReverse = false;

        int front = 0;
        int back = tLen - 1;

        for(int i = sLen ; i < tLen ; i++){
            char c = T.charAt(isReverse?front:back);
            if(c == 'A') {
                if(isReverse) front++;
                else back--;
            }
            else{
                if(isReverse) front++;
                else back--;
                isReverse = !isReverse;
            }
        }

        String str = T.substring(front, back+1);
        StringBuffer sb = new StringBuffer(str);

        if(isReverse) str = sb.reverse().toString();

        if(S.equals(str)) System.out.println(1);
        else System.out.println(0);
    }
}