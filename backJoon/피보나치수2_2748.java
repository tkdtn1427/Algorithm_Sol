package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 브론즈 1
public class 피보나치수2_2748 {
    static long[] fb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer target = Integer.parseInt(br.readLine());
        fb = new long[91];

        if(target == 0 || target == 1){
            System.out.println(target);
        }else{
            fb[0] = 0;
            fb[1] = 1;
            for(int i=2; i<=target; i++){
                fb[i] = fb[i-1] + fb[i-2];
            }
            System.out.println(fb[target]);
        }
    }
}
