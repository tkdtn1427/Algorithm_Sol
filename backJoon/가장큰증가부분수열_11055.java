package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 2
public class 가장큰증가부분수열_11055 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dp = new int[repeat];
        int[] sum = new int[repeat];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<repeat; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<repeat; i++){
            sum[i] = dp[i];
            for(int j=0; j<i; j++){
                if(dp[i] > dp[j] && sum[i] < sum[j]+dp[i]){
                    sum[i] = sum[j] + dp[i];
                }
            }
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}
