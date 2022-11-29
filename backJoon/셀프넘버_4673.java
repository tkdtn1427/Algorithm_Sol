package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 셀프넘버_4673 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[10001];

        for(int i=1; i<=10000; i++){
            int number = i;
            int data = i;
            while (data > 0){
                number += data % 10;
                data /= 10;
            }
            if(dp[i] == 0) System.out.println(i);
            if(number > 10000) continue;
            dp[number] += 1;
        }
    }
}
