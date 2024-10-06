import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        int[] arr = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ten = 1;
        int len = input.length();
        int inputInt = Integer.parseInt(input);

        for(int i = 0 ; i < len ; i++){
            int digit = (inputInt/ten) % 10;
            if(digit == 9) arr[6]++;
            else arr[digit]++;
            ten *= 10;
        }

        int max = 0;
        for(int i = 0 ; i < 9 ; i++){
            if(i == 6) {
                if ((arr[6] + 1) / 2 > max)
                    max = (arr[6] + 1) / 2;
            }
            else if(arr[i] > max) max = arr[i];
        }

        System.out.println(max);
    }
}
