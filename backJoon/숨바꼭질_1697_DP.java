package backJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 1
// DP
public class 숨바꼭질_1697_DP {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        dp = new int[target+1];

        if(target <= start){
            System.out.println(start-target);
            return;
        }

        for(int i=1; i<start; i++){
            dp[i] = start-i;
        }

        for(int i=start+1; i<=target; i++){
            if(i %2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i-1]+1);
            }else{
                dp[i] = Math.min(dp[i-1]+1, dp[(i+1)/2]+2);
            }
        }
        System.out.println(dp[target]);
    }
}