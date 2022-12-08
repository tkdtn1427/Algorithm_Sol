package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 실버 2
// 수학, DP
public class 제곱수의합 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        dp = new int[target+1];

        for(int i=1; i<=target; i++){
            dp[i] = findNumber(i);
        }

        bw.write(String.valueOf(dp[target]));
        bw.flush();
        bw.close();
    }

    static int findNumber(int num){
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=(int)Math.sqrt(num); i++){
            if(min > dp[num - (int)Math.pow(i,2)]){
                min = dp[num - (int)Math.pow(i,2)];
            }
        }
        return min+1;
    }
}
