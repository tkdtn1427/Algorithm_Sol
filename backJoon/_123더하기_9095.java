package backJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 실버3
// DP
public class _123더하기_9095 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<repeat; i++){
            int target = Integer.parseInt(br.readLine());
            dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            if(target <= 3){
                sb.append(dp[target] + "\n");
            }else{
                for(int k=4; k<=target; k++){
                    dp[k] = dp[k-1] + dp[k-2] + dp[k-3];
                }
                sb.append(dp[target] + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}


/*

1

1 + 1, 2

1 + 1 + 1, 1 + 2, 2 + 1, 3

1 + 3
1 + 1 + 2, 2 + 2
1 + 1 + 1 +1 , 1 + 2 + 1, 2 + 1 + 1, 3 + 1



 */