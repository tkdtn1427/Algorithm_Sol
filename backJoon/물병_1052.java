package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버1
// 구현
public class 물병_1052 {
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int prev_bottle = Integer.parseInt(st.nextToken());
        result = -1;
        int target = Integer.parseInt(st.nextToken());
        int count;

        do {
            result++;
            count=0;
            int temp = prev_bottle;
            while (temp != 0){
                if(temp % 2 == 1) count++;
                temp /= 2;
            }
            prev_bottle++;
        }while (target < count);

        System.out.println(result);
    }
}
